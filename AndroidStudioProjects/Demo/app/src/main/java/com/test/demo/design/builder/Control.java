package com.test.demo.design.builder;

/**
 * Created by lizhilog0919 on 2017/3/9.
 */

public class Control {

    private Builder mBuilder;

    public Control(Builder builder){
        mBuilder = builder;
    }

    public void setBuilder(Builder builder) {
        mBuilder = builder;
    }

    public void product(){
        mBuilder.buildPartA();
        mBuilder.buildPartB();
    }


}
