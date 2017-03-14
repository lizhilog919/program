package com.test.demo.design.adapter;

/**
 * Created by lizhilog0919 on 2017/3/9.
 */

public class RealTask implements RealInterface {
    @Override
    public void realRequest() {
        System.out.println("do task");
    }
}
