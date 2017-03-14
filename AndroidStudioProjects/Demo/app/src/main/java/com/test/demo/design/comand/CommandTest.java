package com.test.demo.design.comand;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public class CommandTest {
    public static void main(String[] args){
        Receiver receiver = new RealReceiver();
        Command command = new RealCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}
