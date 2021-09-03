package com.wyk.wisper.socket.one;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wuyongkang
 * @date 2021年08月10日 16:45
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            HandlerSocketServerPool handlerSocketServerPool = new HandlerSocketServerPool(3, 10);
            while (true) {
                Socket accept = serverSocket.accept();
                Runnable serverRunable = new ServerRunable(accept);
                handlerSocketServerPool.execute(serverRunable);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}