package com.test.demo.design.decorator;

/**
 * Created by lizhilog0919 on 2017/3/9.
 */

public class DecoratorB extends Decorator {

    public DecoratorB(Component component) {
        super(component);
    }

    @Override
    public void execute() {
        super.execute();
        doLast();
    }

    private void doLast(){
        System.out.println("B do last");
    }
}
