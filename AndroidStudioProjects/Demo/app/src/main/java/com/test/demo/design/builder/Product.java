package com.test.demo.design.builder;

/**
 * Created by lizhilog0919 on 2017/3/9.
 */

public class Product {
    Part mPartA;
    Part mPartB;

    public void setPartA(Part partA) {
        mPartA = partA;
    }

    public void setPartB(Part partB) {
        mPartB = partB;
    }

    @Override
    public String toString() {
        return mPartA.print() + " : " +mPartB.print();
    }
}
