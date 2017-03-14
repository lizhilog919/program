package com.test.demo.design.decorator;

/**
 * Created by lizhilog0919 on 2017/3/9.
 */

public class DecoratorTest {

    public static void main(String[] args){
        Decorator decoratorA = new DecoratorA(new RealComponent());
        decoratorA.execute();
        Decorator decoratorB = new DecoratorB(new RealComponent());
        decoratorB.execute();
    }
}
