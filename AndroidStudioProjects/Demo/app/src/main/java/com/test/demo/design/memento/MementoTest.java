package com.test.demo.design.memento;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public class MementoTest {
    public static void main(String[] args){
        Original original = new Original();
        original.setValue("value");
        System.out.println(original);
        Storage storage = new Storage(original.createMemento());
        original.setValue("test");
        System.out.println(original);
        original.restoreMemento(storage.getMemento());
        System.out.println(original);
    }
}
