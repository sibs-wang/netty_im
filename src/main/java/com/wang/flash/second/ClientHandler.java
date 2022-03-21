package com.wang.flash.second;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandler {

    public static final int MAX_DATA_LEN = 1024;

    private final Socket socket;

    public ClientHandler(Socket client) {
        this.socket = client;
    }

    public void start() {
        System.out.println("新客户端接入");
        // 为什么需要
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    public void doStart() {
        try {
            InputStream inputStream = socket.getInputStream();
            while(true) {
                // pipeline
                byte[] data = new byte[MAX_DATA_LEN];

                int len;
                while ((len = inputStream.read(data)) != -1) {
                    String message = new String(data, 0, len);
                    System.out.println("客户端传来消息: " + message);
                    socket.getOutputStream().write(data);
                }
            }
        } catch (IOException e) {
            System.out.println();
        }
    }
}
