package com.test.demo.design.comand;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public class Invoker {
    Command mCommand;

    public Invoker(Command command){
        mCommand = command;
    }

    public void action(){
        System.out.println("send command");
        mCommand.execute();
    }
}
