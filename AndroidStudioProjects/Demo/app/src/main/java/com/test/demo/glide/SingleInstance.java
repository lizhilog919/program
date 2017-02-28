package com.test.demo.glide;

/**
 * Created by lizhi
 * 17-2-24
 */
public class SingleInstance {

    public static SingleInstance sInstance;

    private SingleInstance(){}

    public static SingleInstance getInstance(){
        if(sInstance != null){
            synchronized (SingleInstance.class){
                sInstance = new SingleInstance();
            }
        }
        return sInstance;
    }



}
