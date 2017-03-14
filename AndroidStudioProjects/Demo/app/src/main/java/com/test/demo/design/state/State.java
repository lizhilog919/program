package com.test.demo.design.state;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public enum State {
    STATE_1,
    STATE_2;

    public void method1(){
        System.out.println("execute on state1");
    }

    public void method2(){
        System.out.println("execute on state2");
    }
}
