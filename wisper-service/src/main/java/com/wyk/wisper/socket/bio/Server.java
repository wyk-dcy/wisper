package com.wyk.wisper.socket.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wuyongkang
 * @date 2021年08月10日 14:03
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            if ((msg = inputStreamReader.readLine()) != null) {
                System.out.println("服务器连接" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}