package com.test.demo.design.iterator;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public interface Collection<T> {
    Iterator iterator();
    int size();
    T get(int i);

}
