package com.test.demo.design.responsibility;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public class RealHandler extends AbstractHandler implements Handler{

    private String str;

    RealHandler(String str){
        this.str = str;
    }

    @Override
    public void operate() {
        System.out.println(str);
        if(getHandler() != null){
            getHandler().operate();
        }
    }
}
