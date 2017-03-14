package com.test.demo.design.responsibility;

/**
 * 责任模式
 * Created by Li Zhi
 * 2017/3/10.
 */

public abstract class AbstractHandler {
    private Handler mHandler;

    public void setHandler(Handler handler) {
        mHandler = handler;
    }

    public Handler getHandler() {
        return mHandler;
    }
}
