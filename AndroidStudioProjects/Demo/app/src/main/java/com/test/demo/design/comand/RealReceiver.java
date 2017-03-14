package com.test.demo.design.comand;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public class RealReceiver implements Receiver {
    @Override
    public void action() {
        System.out.println("Command is receiver");
    }
}
