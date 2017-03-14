package com.test.demo.design.observer;

/**
 * 被观察实体
 * Created by Li Zhi
 * 2017/3/10.
 */

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
    void operation();
}
