package com.test.demo.design.visitor;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public interface Subject<T> {
    void accept(Visitor visitor);
    T getSubject();
}
