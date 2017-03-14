package com.test.demo.design.visitor;

/**
 * 访问者模式
 * Created by Li Zhi
 * 2017/3/10.
 */

public interface Visitor<T> {
    void visit(Subject<T> subject);
}
