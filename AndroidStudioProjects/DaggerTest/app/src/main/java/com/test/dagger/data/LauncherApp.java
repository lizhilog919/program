package com.test.dagger.data;

import javax.inject.Inject;

/**
 * Created by Li Zhi
 * 2017/6/25.
 */

public class LauncherApp {
    private String name;
    private int size;

    public LauncherApp(){
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "LauncherApp{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
