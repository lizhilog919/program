package com.test.demo.design.facade;

import com.test.demo.design.decorator.Component;

/**
 * 外观模式
 * Created by Li Zhi
 * 2017/3/9.
 */

public class Computer {

    private CPU mCPU;
    private Disk mDisk;

    public Computer(){
        mCPU =new CPU();
        mDisk = new Disk();
    }

    public void start(){
        System.out.println("Computer start");
        mCPU.start();
        mDisk.start();
    }
}
