package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioServer {

    private static final int PORT = 8080;
    // Integer：client的id | Long：当前系统的时间戳
    private static final ConcurrentHashMap<Integer, Long> activeClients = new ConcurrentHashMap<>();
    private static final Object LOCK = new Object();

    public static void main(String[] args) throws IOException {
        // 添加内存监控
        Runtime runtime = Runtime.getRuntime();
        // 创建缓存线程池，线程可复用
        //noinspection AlibabaThreadPoolCreation
        ExecutorService pool = Executors.newCachedThreadPool();
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("BIO Server started on port " + PORT);

            while (true) {
                // 等待直到用户连接
                Socket clientSocket = serverSocket.accept();
                pool.execute(new ClientHandler(clientSocket));
                System.out.println("总内存" + runtime.totalMemory() / 1024 / 1024 + "MB" + "\t" + "空闲内存" + runtime.freeMemory() / 1024 / 1024 + "MB" + "\t" + "占用内存" + (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024 + "MB");
            }
        }
    }

    /**
     * 实现Runnable，以便可以被线程执行
     */
    static class ClientHandler implements Runnable {
        private final Socket socket;
        private final int clientId;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            this.clientId = new Random().nextInt(9000) + 1000; // 生成4位随机ID
        }

        /**
         * 默认实现该方法
         */
        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                // 记录活跃客户端
                activeClients.put(clientId, System.currentTimeMillis());
                System.out.println("Client " + clientId + " connected. Active clients: " + activeClients.size());

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    // 更新最后操作时间
                    activeClients.put(clientId, System.currentTimeMillis());

                    synchronized (LOCK) {
                        // 检测并发操作
                        List<Integer> concurrentUsers = findConcurrentUsers(clientId);
                        if (!concurrentUsers.isEmpty()) {
                            System.out.println("Client " + clientId + " & " + concurrentUsers + " are operating concurrently");
                        } else {
                            System.out.println("Client " + clientId + " is writing. Waiting users: " + getWaitingUsers(clientId));
                        }
                    }

                    // 处理请求
                    String response = "Server response to " + clientId + ": " + inputLine.toUpperCase();
                    out.println(response);
                }
            } catch (IOException e) {
                System.err.println("Error handling client " + clientId);
            } finally {
                activeClients.remove(clientId);
                System.out.println("Client " + clientId + " disconnected");
            }
        }

        private List<Integer> findConcurrentUsers(int currentClient) {
            List<Integer> concurrent = new ArrayList<>();
            long currentTime = System.currentTimeMillis();
            // 遍历key，value
            for (Map.Entry<Integer, Long> entry : activeClients.entrySet()) {
                int client = entry.getKey();
                long lastOpTime = entry.getValue();
                if (client != currentClient && (currentTime - lastOpTime) < 100) { // 100ms内视为并发
                    concurrent.add(client);
                }
            }
            return concurrent;
        }

        private List<Integer> getWaitingUsers(int currentClient) {
            List<Integer> waiting = new ArrayList<>();
            for (Integer client : activeClients.keySet()) {
                if (client != currentClient) {
                    waiting.add(client);
                    System.out.println();
                }
            }
            return waiting;
        }
    }
}
