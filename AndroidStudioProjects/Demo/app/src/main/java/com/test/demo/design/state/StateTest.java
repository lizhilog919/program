package com.test.demo.design.state;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public class StateTest {
    public static void main(String[] args){
        Context context = new Context();
        context.setState(State.STATE_1);
        context.method();
        context.setState(State.STATE_2);
        context.method();
    }
}
