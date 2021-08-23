package com.wyk.wisper.socket.one;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author wuyongkang
 * @date 2021年08月10日 16:43
 */
public class ServerRunable implements Runnable{
    private Socket socket;
    public ServerRunable(Socket socket){
        this.socket = socket;

    }
    @SneakyThrows
    @Override
    public void run() {
        InputStream inputStream = socket.getInputStream();
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(inputStream));
        String msg;
        if ((msg = inputStreamReader.readLine()) != null) {
            System.out.println("服务器连接" + msg);
        }

    }
}