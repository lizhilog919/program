package com.test.demo.design.factory;

/**
 * Created by lizhilog0919 on 2017/3/9.
 */

public class SimpleFactory {


    public interface Animal {
        String type();
    }

    public static class Cat implements Animal {

        @Override
        public String type() {
            return "CAT_TYPE";
        }
    }

    public static class Pig implements Animal {

        @Override
        public String type() {
            return "PIG_TYPE";
        }
    }


    /**
     * 简单工厂模式
     * @param type
     * @return
     */
    public Animal getAnimal(int type) {
        switch (type) {
            case 0:
                return new Cat();
            case 1:
                return new Pig();
            default:
                return null;
        }
    }

    /**
     * 静态工厂模式
     * @return
     */
    public static Animal getCat(){
        return new Cat();
    }

    public static Animal getPig(){
        return new Pig();
    }

}
