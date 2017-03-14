package com.test.demo.design.visitor;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public class VisitorTest {
    public static void main(String[] args){
        RealSubject realSubject = new RealSubject("we");
        RealVisitor realVisitor= new RealVisitor();
        realSubject.accept(realVisitor);
    }
}
