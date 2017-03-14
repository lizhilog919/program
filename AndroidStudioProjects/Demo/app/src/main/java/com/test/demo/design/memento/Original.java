package com.test.demo.design.memento;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public class Original {
    String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Memento createMemento(){
        Memento memento = new Memento(value);
        return memento;
    }

    public void restoreMemento(Memento memento){
        this.value = memento.value;
    }

    @Override
    public String toString() {
        return "value: " + value;
    }
}
