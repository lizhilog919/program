package com.test.demo.xml;

/**
 * Created by Li Zhi
 * 2017/3/29.
 */

public class Book {
    private int id;
    private String name;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name="+name+", date="+date;
    }
}
