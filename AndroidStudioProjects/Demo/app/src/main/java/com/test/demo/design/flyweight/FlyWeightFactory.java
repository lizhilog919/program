package com.test.demo.design.flyweight;

import java.util.Vector;

/**
 * 享元管理者
 * Created by Li Zhi
 * 2017/3/9.
 */

public class FlyWeightFactory {

    private int mSize;
    private Vector<FlyWeight> mVector;
    private static FlyWeightFactory sInstance;

    private FlyWeightFactory(int size) {
        mSize = size;
        mVector = new Vector<>();
        for (int i = 0; i < mSize; i++) {
            FlyWeight flyWeight = new FlyWeight();
            mVector.add(flyWeight);
        }
    }

    public static FlyWeightFactory getInstance(int size) {
        if (sInstance == null) {
            synchronized (FlyWeightFactory.class) {
                if (sInstance == null) {
                    sInstance = new FlyWeightFactory(size);
                }
            }
        }
        return sInstance;
    }

    public synchronized FlyWeight getFlyWeight(){
        if(mVector.size() > 0){
            FlyWeight flyWeight = mVector.get(0);
            mVector.remove(0);
            return flyWeight;
        }
        return null;
    }
}
