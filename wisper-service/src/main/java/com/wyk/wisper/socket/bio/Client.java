package com.wyk.wisper.socket.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author wuyongkang
 * @date 2021年08月10日 14:03
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",9999);
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println("服务器你好");
        printStream.flush();
    }
}