package com.test.demo.thread;

import android.os.HandlerThread;

/**
 * Created by Li Zhi
 * 2017/4/12.
 */

public class MyHandlerThread extends HandlerThread {

    static int i = 0;

    public MyHandlerThread(String name, int priority) {
        super(name, priority);
    }

    public MyHandlerThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (i++<40){
            System.out.println("run tag : " + i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.run();
    }
}
