package com.test.demo.design.responsibility;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public class HandlerTest {
    public static void main(String[] a){
        RealHandler handler1 = new RealHandler("A");
        RealHandler handler2 = new RealHandler("B");
        RealHandler handler3 = new RealHandler("C");
        handler1.setHandler(handler2);
        handler2.setHandler(handler3);
        handler1.operate();
    }
}
