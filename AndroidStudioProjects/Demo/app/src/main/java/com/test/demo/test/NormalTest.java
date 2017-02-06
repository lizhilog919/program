package com.test.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lizhi
 * 16-12-30
 */
public class NormalTest {

    public static void main(String args[]){
        long time = System.currentTimeMillis();
        List<Student> students = new ArrayList<>();
        int N = 100000;
        for(int i=0;i<N;i++){
            Student student = new Student();
            student.setName("lizhi");
            student.setOld(20);
            students.add(student);
        }
        System.out.println("write student list :" + String.valueOf(System.currentTimeMillis() - time));
        time = System.currentTimeMillis();

        List<Map> maps = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Map map = new HashMap();
            map.put("name", "lizhi");
            map.put("old", 20);
            maps.add(map);
        }
        System.out.println("write map list :" + String.valueOf(System.currentTimeMillis() - time));
        time = System.currentTimeMillis();

        for (int i = 0; i < students.size(); i++) {
            String name = students.get(i).getName();
            int old = students.get(i).getOld();
        }

        System.out.println("read student list :" + String.valueOf(System.currentTimeMillis() - time));
        time = System.currentTimeMillis();

        for (int i = 0; i < maps.size(); i++) {
            String name = (String) maps.get(i).get("name");
            int old = (int) maps.get(i).get("old");
        }

        System.out.println("read map list :" + String.valueOf(System.currentTimeMillis() - time));

    }

    public static class Student{

        private String name;
        private int old;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOld() {
            return old;
        }

        public void setOld(int old) {
            this.old = old;
        }
    }
}