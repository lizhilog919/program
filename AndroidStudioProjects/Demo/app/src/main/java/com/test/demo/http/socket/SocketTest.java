package com.test.demo.http.socket;

import com.test.demo.design.memento.Memento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Li Zhi
 * 2017/3/13.
 */

public class SocketTest {

    public static void main(String[] args){

        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println("ip: " + getLocalIpAddress());
        try {
            ServerSocket serverSocket = new ServerSocket(1680);
            Socket socket = serverSocket.accept();
            service.execute(new SocketRunnable(socket));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class SocketRunnable implements Runnable{

        Socket mSocket;

        public SocketRunnable(Socket socket){
            mSocket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = mSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String message = reader.readLine();
                System.out.println("message: " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getLocalIpAddress() {
        try {

            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();

                 en.hasMoreElements();) {

                NetworkInterface intf = en.nextElement();

                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses();

                     enumIpAddr.hasMoreElements();) {

                    InetAddress inetAddress = enumIpAddr.nextElement();

                    if (!inetAddress.isLoopbackAddress()) {

                        return inetAddress.getHostAddress().toString();

                    }

                }

            }

        } catch (SocketException ex) {
        }
        return null;
    }

}
