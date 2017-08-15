package com.test.demo.thread;

import android.os.Handler;
import android.os.Process;

/**
 * Created by Li Zhi
 * 2017/4/12.
 */

public class SendRunnable implements Runnable {

    static int n = 50;

    public SendRunnable(Handler handler){
        mHandler = handler;
    }

    Handler mHandler;

    @Override
    public void run() {
        Process.setThreadPriority(Process.THREAD_PRIORITY_DEFAULT);
        while (n++< 80){
            System.out.println("send tag : " + n);
            if(n == 60){
                mHandler.sendEmptyMessage(0);
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
