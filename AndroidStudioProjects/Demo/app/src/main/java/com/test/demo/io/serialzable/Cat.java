package com.test.demo.io.serialzable;

import java.io.Serializable;

/**
 * Created by lizhilog0919 on 2017/3/6.
 */

public class Cat implements Serializable {
    int a;
    String b;
    int c;

    public Cat(String b, int a, int c) {
        this.b = b;
        this.a = a;
        this.c = c;
    }

    @Override
    public String toString() {
        return "a: "+ a + " b: "+b +" c: " + c;
    }
}
