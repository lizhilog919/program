package com.test.demo.http.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Li Zhi
 * 2017/3/13.
 */

public class SocketTest {

    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(1000);
            Socket socket = serverSocket.accept();
            Socket socket1 = new Socket("12",1);
            InputStream is = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
