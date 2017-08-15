package com.test.demo.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.StatFs;


/**
 * Created by Li Zhi
 * 2017/4/12.
 */

public class ThreadTest {
    public static void main(String[] args){
        HandlerThread handlerThread = new MyHandlerThread("test");
        Handler handler = new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                System.out.print("receive msg!");
            }
        };
        handlerThread.start();
        new Thread(new SendRunnable(handler)).start();
    }

}
