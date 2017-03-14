package com.test.demo.design.visitor;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public class RealVisitor implements Visitor<String> {
    @Override
    public void visit(Subject<String> subject) {
        System.out.println(subject.getSubject());
    }
}
