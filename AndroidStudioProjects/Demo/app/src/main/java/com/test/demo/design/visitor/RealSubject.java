package com.test.demo.design.visitor;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public class RealSubject implements Subject<String> {

    private String mValue;

    public RealSubject(String value){
        mValue = value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return mValue;
    }
}
