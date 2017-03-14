package com.test.demo.design.decorator;

/**
 * 装饰器模式
 * Created by Li Zhi
 * 2017/3/9.
 */

public class Decorator implements Component {

    protected Component mComponent;

    public Decorator(Component component){
        mComponent = component;
    }

    @Override
    public void execute() {
        mComponent.execute();
    }
}
