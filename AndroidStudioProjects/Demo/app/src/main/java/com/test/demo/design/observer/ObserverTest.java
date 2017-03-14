package com.test.demo.design.observer;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public class ObserverTest {

    public static void main(String[] args){
        Observer observerA = new ObserverA();
        Observer observerB = new ObserverB();
        Subject subject = new RealSubject();
        subject.addObserver(observerA);
        subject.addObserver(observerB);
        subject.operation();
    }

    public static class ObserverA implements Observer{

        @Override
        public void update() {
            System.out.println("ObserverA is received");
        }
    }

    public static class ObserverB implements Observer{

        @Override
        public void update() {
            System.out.println("ObserverB is received");
        }
    }

    public static class RealSubject extends AbstractSubject{

        @Override
        public void operation() {
            System.out.println("do task");
            notifyObserver();
        }
    }
}
