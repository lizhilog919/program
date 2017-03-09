package com.test.demo.design.single;

/**
 * Created by lizhi
 * 17-3-2
 */
public class SingleInstance {

    public static SingleInstance sInstance = null;

    private SingleInstance(){}

    public static SingleInstance getInstance(){
        if(sInstance == null){
            synchronized (SingleInstance.class){
                if(sInstance == null){
                    sInstance = new SingleInstance();
                }
            }
        }
        return sInstance;
    }

}
