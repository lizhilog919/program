package com.test.demo.design.comand;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public class RealCommand implements Command {

    Receiver mReceiver;

    RealCommand(Receiver receiver){
        mReceiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("Command to receiver");
        mReceiver.action();
    }
}
