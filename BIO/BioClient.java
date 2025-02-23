package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BioClient {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        //noinspection AlibabaThreadPoolCreation
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                try (Socket socket = new Socket(HOST, PORT);
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                    // 随机发送消息
                    Random rand = new Random();
                    for (int j = 0; j < 5; j++) {
                        String message = "Message-" + j;
                        out.println(message);
                        String response = in.readLine();
                        System.out.println("Received: " + response);
                        TimeUnit.MILLISECONDS.sleep(rand.nextInt(500)); // 随机间隔0-500ms
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        pool.shutdown();
    }
}
