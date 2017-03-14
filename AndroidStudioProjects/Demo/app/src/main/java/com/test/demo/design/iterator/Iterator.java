package com.test.demo.design.iterator;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public interface Iterator<T> {
    T pre();
    T next();
    boolean hasNext();
    T first();
}
