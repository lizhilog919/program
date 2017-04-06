package com.test.demo.java;

/**
 * Created by Li Zhi
 * 2017/3/28.
 */

public class EnumTest {

    public enum Week{
        SUNDAY {
            @Override
            void eat() {
                System.out.println("eat delicious");
            }
        },

        SATURDAY {
            @Override
            void eat() {
                System.out.println("eat peat");
            }
        };

        abstract void eat();
    }


    public static void main(String[] args){
        Week week = Week.SUNDAY;
        week.eat();
    }
}
