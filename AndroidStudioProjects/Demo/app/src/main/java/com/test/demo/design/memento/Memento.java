package com.test.demo.design.memento;

/**
 * 备忘录模式
 * Created by Li Zhi
 * 2017/3/10.
 */

public class Memento {
    String value;

    Memento(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
