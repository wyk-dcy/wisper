package com.wyk.wisper.socket.one;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author wuyongkang
 * @date 2021年08月10日 16:47
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",9999);
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("请说");
                String msg = scanner.nextLine();
                printStream.println(msg);
                printStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}