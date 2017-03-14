package com.test.demo.test;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

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

    private void test(){
        Reader reader;
        DataInputStream dataInputStream;
        OutputStream outputStream;
        InputStream inputStream;
        Writer writer;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread.interrupt();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            timeUnit.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread1 = new Thread(r);
                thread1.setDaemon(true);
                return thread1;
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    public static interface Generator<T>{
        T next();
    }

    public static class IntegerGenerator implements Generator<Integer>{

        private int num = 0;
        List<Integer> a;

        @Override
        public Integer next() {
            return num++;
        }

        public void test(List<Integer> b){
            Collection<Integer> collection;
            Map<Integer,Integer> map;
        }
         public void test(float b){
             Stack stack;
             PriorityQueue<Float> queue = new PriorityQueue<>(12, new Comparator<Float>() {
                 @Override
                 public int compare(Float aFloat, Float t1) {
                     return 0;
                 }
             });
         }

       /* public void test(List<Float> c){

        }*/
    }
}
