package com.test.demo.design.decorator;

/**
 * Created by lizhilog0919 on 2017/3/9.
 */

public class DecoratorA extends Decorator {

    public DecoratorA(Component component) {
        super(component);
    }

    @Override
    public void execute() {
        doFirst();
        super.execute();
    }

    private void doFirst(){
        System.out.println("A do first");
    }
}
