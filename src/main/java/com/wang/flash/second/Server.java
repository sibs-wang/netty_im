package com.wang.flash.second;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("服务器启动成功,端口:" + port);
        } catch (IOException e) {
            System.out.println("服务器启动失败");
        }
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    public void doStart() {
        while(true) {
            try {
                // 阻塞的方法
                // 等价于.handler(new ServerHandler())
                Socket client = serverSocket.accept();
                new ClientHandler(client).start();
            } catch (IOException e) {
                System.out.println("服务器异常");
            }
        }
    }
}
