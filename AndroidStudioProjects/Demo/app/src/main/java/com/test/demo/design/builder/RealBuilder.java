package com.test.demo.design.builder;

/**
 * Created by lizhilog0919 on 2017/3/9.
 */

public class RealBuilder implements Builder {

    Product mProduct;

    public RealBuilder(){
        mProduct = new Product();
    }

    @Override
    public void buildPartA() {
        Part part = new PartA();
        mProduct.setPartA(part);
    }

    @Override
    public void buildPartB() {
        Part part = new PartB();
        mProduct.setPartB(part);
    }

    public Product getProduct() {
        return mProduct;
    }
}
