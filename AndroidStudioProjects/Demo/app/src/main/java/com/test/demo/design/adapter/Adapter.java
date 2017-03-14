package com.test.demo.design.adapter;

/**
 * Created by lizhilog0919 on 2017/3/9.
 */

public class Adapter implements RequireInterface{

    private RealInterface mRealInterface;

    public Adapter(){
        mRealInterface = new RealTask();
    }

    @Override
    public void request() {
        mRealInterface.realRequest();
    }
}
