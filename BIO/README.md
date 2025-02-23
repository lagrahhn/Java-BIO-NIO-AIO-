## 运行server并接收client

```
BIO Server started on port 8080
Client 2660 connected. Active clients: 1
总内存246MB	空闲内存241MB	占用内存4MB
总内存246MB	空闲内存241MB	占用内存4MB
Client 5325 connected. Active clients: 2
总内存246MB	空闲内存240MB	占用内存5MB
Client 7916 connected. Active clients: 3
总内存246MB	空闲内存240MB	占用内存5MB
Client 3569 connected. Active clients: 4
总内存246MB	空闲内存240MB	占用内存6MB
Client 2163 connected. Active clients: 5
总内存246MB	空闲内存239MB	占用内存6MB
Client 3162 connected. Active clients: 6
总内存246MB	空闲内存239MB	占用内存6MB
Client 7739 connected. Active clients: 7
总内存246MB	空闲内存238MB	占用内存7MB
Client 6535 connected. Active clients: 8
总内存246MB	空闲内存238MB	占用内存7MB
Client 8642 connected. Active clients: 9
总内存246MB	空闲内存238MB	占用内存8MB
Client 4966 connected. Active clients: 10
Client 2660 is writing. Waiting users: []
Client 4966 & [3569, 8642, 2163, 2660, 6535, 3162, 7739, 7916, 5325] are operating concurrently
Client 8642 & [3569, 2163, 2660, 4966, 6535, 3162, 7739, 7916, 5325] are operating concurrently
Client 6535 & [3569, 8642, 2163, 2660, 4966, 3162, 7739, 7916, 5325] are operating concurrently
Client 7739 & [3569, 8642, 2163, 2660, 4966, 6535, 3162, 7916, 5325] are operating concurrently
Client 3162 & [3569, 8642, 2163, 2660, 4966, 6535, 7739, 7916, 5325] are operating concurrently
Client 2163 & [3569, 8642, 2660, 4966, 6535, 3162, 7739, 7916, 5325] are operating concurrently
Client 3569 & [8642, 2163, 2660, 4966, 6535, 3162, 7739, 7916, 5325] are operating concurrently
Client 7916 & [3569, 8642, 2163, 2660, 4966, 6535, 3162, 7739, 5325] are operating concurrently
Client 5325 & [3569, 8642, 2163, 2660, 4966, 6535, 3162, 7739, 7916] are operating concurrently
Client 7916 & [3569, 8642, 2163, 2660, 4966, 6535, 3162, 7739, 5325] are operating concurrently
Client 2163 & [3569, 8642, 2660, 4966, 6535, 3162, 7739, 7916, 5325] are operating concurrently
Client 2660 & [2163, 7916] are operating concurrently
Client 7739 & [2163, 2660, 7916] are operating concurrently
Client 8642 & [2660, 7739] are operating concurrently
Client 3569 & [8642] are operating concurrently
Client 2163 & [3569, 8642] are operating concurrently
Client 7739 & [3569, 2163] are operating concurrently
Client 3162 & [3569, 2163, 7739] are operating concurrently
Client 4966 & [3569, 2163, 3162, 7739] are operating concurrently
Client 6535 & [2163, 4966, 3162, 7739] are operating concurrently
Client 7916 & [2163, 4966, 6535, 3162, 7739] are operating concurrently
Client 8642 & [2163, 4966, 6535, 3162, 7739, 7916] are operating concurrently
Client 5325 & [8642, 4966, 6535, 3162, 7739, 7916] are operating concurrently
Client 2163 & [8642, 4966, 6535, 3162, 7916, 5325] are operating concurrently
Client 3162 & [8642, 2163, 4966, 6535, 7916, 5325] are operating concurrently
Client 7739 & [8642, 2163, 4966, 6535, 3162, 7916, 5325] are operating concurrently
Client 2163 & [3162, 7739] are operating concurrently
Client 2660 & [2163, 7739] are operating concurrently
Client 3569 & [2660] are operating concurrently
Client 4966 & [3569] are operating concurrently
Client 3569 & [4966] are operating concurrently
Client 8642 & [3569, 4966] are operating concurrently
Client 7739 & [3569, 8642, 4966] are operating concurrently
Client 6535 & [3569, 8642, 7739] are operating concurrently
Client 3569 & [8642, 6535, 7739] are operating concurrently
Client 3162 & [3569, 8642, 6535, 7739] are operating concurrently
Client 7916 & [3569, 8642, 6535, 3162, 7739] are operating concurrently
Client 8642 & [3569, 6535, 3162, 7739, 7916] are operating concurrently
Client 5325 & [3569, 8642, 6535, 3162, 7739, 7916] are operating concurrently
Client 2163 disconnected
Client 2660 is writing. Waiting users: [3569, 8642, 4966, 6535, 3162, 7739, 7916, 5325]
Client 7916 & [2660] are operating concurrently
Client 8642 disconnected
Client 4966 & [2660, 7916] are operating concurrently
Client 7739 disconnected
Client 5325 & [4966] are operating concurrently
Client 5325 is writing. Waiting users: [3569, 2660, 4966, 6535, 3162, 7916]
Client 3569 disconnected
Client 3162 is writing. Waiting users: [2660, 4966, 6535, 7916, 5325]
Client 6535 & [3162] are operating concurrently
Client 7916 disconnected
Client 3162 disconnected
Client 6535 is writing. Waiting users: [2660, 4966, 5325]
Client 2660 & [6535] are operating concurrently
Client 4966 & [2660, 6535] are operating concurrently
Client 4966 disconnected
Client 5325 disconnected
Client 6535 disconnected
Client 2660 disconnected
```

## 运行client

```
Received: Server response to 3569: MESSAGE-0
Received: Server response to 2163: MESSAGE-0
Received: Server response to 3162: MESSAGE-0
Received: Server response to 7916: MESSAGE-0
Received: Server response to 2660: MESSAGE-0
Received: Server response to 5325: MESSAGE-0
Received: Server response to 4966: MESSAGE-0
Received: Server response to 8642: MESSAGE-0
Received: Server response to 6535: MESSAGE-0
Received: Server response to 7739: MESSAGE-0
Received: Server response to 7916: MESSAGE-1
Received: Server response to 2163: MESSAGE-1
Received: Server response to 2660: MESSAGE-1
Received: Server response to 7739: MESSAGE-1
Received: Server response to 8642: MESSAGE-1
Received: Server response to 3569: MESSAGE-1
Received: Server response to 2163: MESSAGE-2
Received: Server response to 7739: MESSAGE-2
Received: Server response to 3162: MESSAGE-1
Received: Server response to 4966: MESSAGE-1
Received: Server response to 6535: MESSAGE-1
Received: Server response to 7916: MESSAGE-2
Received: Server response to 8642: MESSAGE-2
Received: Server response to 5325: MESSAGE-1
Received: Server response to 2163: MESSAGE-3
Received: Server response to 3162: MESSAGE-2
Received: Server response to 7739: MESSAGE-3
Received: Server response to 2163: MESSAGE-4
Received: Server response to 2660: MESSAGE-2
Received: Server response to 3569: MESSAGE-2
Received: Server response to 4966: MESSAGE-2
Received: Server response to 3569: MESSAGE-3
Received: Server response to 8642: MESSAGE-3
Received: Server response to 7739: MESSAGE-4
Received: Server response to 6535: MESSAGE-2
Received: Server response to 3569: MESSAGE-4
Received: Server response to 3162: MESSAGE-3
Received: Server response to 7916: MESSAGE-3
Received: Server response to 8642: MESSAGE-4
Received: Server response to 5325: MESSAGE-2
Received: Server response to 2660: MESSAGE-3
Received: Server response to 7916: MESSAGE-4
Received: Server response to 4966: MESSAGE-3
Received: Server response to 5325: MESSAGE-3
Received: Server response to 5325: MESSAGE-4
Received: Server response to 3162: MESSAGE-4
Received: Server response to 6535: MESSAGE-3
Received: Server response to 6535: MESSAGE-4
Received: Server response to 2660: MESSAGE-4
Received: Server response to 4966: MESSAGE-4
```
