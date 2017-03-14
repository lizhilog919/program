package com.test.demo.design.decorator;

/**
 * Created by lizhilog0919 on 2017/3/9.
 */

public class RealComponent implements Component {
    @Override
    public void execute() {
        System.out.println("real task");
    }
}
