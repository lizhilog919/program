package com.test.demo.design.builder;

/**
 * Created by lizhilog0919 on 2017/3/9.
 */

public class BuilderTest {

    public static void main(String[] args){
        RealBuilder builder = new RealBuilder();
        Control control  =new Control(builder);
        control.product();
        System.out.println(builder.getProduct());
    }
}
