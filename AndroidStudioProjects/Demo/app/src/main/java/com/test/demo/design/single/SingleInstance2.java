package com.test.demo.design.single;

/**
 * Created by lizhilog0919 on 2017/3/9.
 */

public class SingleInstance2 {

    private SingleInstance2(){}

    public static class Inter{
        public static final SingleInstance2 INSTANCE_2 = new SingleInstance2();
    }

    public static SingleInstance2 getInstance(){
        return Inter.INSTANCE_2;
    }
}
