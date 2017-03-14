package com.test.demo.design.strategy;

/**
 * Created by Li Zhi
 * 2017/3/9.
 */

public class StrategyTest {
    public static void main(String args[]){
        Context context = new Context(new QuickSortStrategy());
        Integer[] data = new Integer[]{1,6,2,34,7,32,5};
        context.execute(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " , ");
        }

    }
}
