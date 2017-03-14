package com.test.demo.design.observer;

import java.util.Vector;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public abstract class AbstractSubject implements Subject {

    private Vector<Observer> mObservers = new Vector<>();

    @Override
    public void addObserver(Observer observer) {
        mObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        mObservers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : mObservers) {
            observer.update();
        }
    }
}
