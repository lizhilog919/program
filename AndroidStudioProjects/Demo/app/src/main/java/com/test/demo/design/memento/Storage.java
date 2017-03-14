package com.test.demo.design.memento;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public class Storage {

    Memento mMemento;

    Storage(Memento memento){
        mMemento = memento;
    }

    public void setMemento(Memento memento) {
        mMemento = memento;
    }

    public Memento getMemento() {
        return mMemento;
    }
}
