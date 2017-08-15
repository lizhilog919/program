package com.test.demo.algorithm;

import com.test.demo.design.responsibility.Handler;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * 数组中寻找两数之和等于N
 * Created by Li Zhi
 * 2017/4/11.
 */

public class Algorithm1 {

    public static void main(String[] args){

        int[] data = new int[]{1,4,7,2,8,6};
        int N = 8;
        Search search = new Best();
        search.result(data, N);

    }


    public static class Best implements Search{

        @Override
        public void result(int[] data, int N) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < data.length; i++) {
                hashMap.put(N - data[i],data[i]);
            }
            for (int i = 0; i < data.length; i++) {
                if(hashMap.containsValue(N-data[i])){
                    System.out.println((N - data[i]) + " + " + hashMap.get(N-data[i]) + " = " + N);
                    return;
                }
            }
        }
    }


    public static interface Search{
        void result(int[] data, int N);
    }

}
