package com.test.demo.design.strategy;

import java.util.List;

/**
 * Created by Li Zhi
 * 2017/3/9.
 */

public class Context {
    Strategy mStrategy;

    public Context(Strategy strategy){
        this.mStrategy = strategy;
    }

    public void execute(Integer[] data){
        mStrategy.sort(data);
    }
}
