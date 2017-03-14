package com.test.demo.design.factory;

/**
 * 抽象工厂模式
 * Created by lizhilog0919 on 2017/3/9.
 */

public class AbstractFactory {

    public interface AbstractProvider{
        SimpleFactory.Animal build();
    }

    public static class RealCatFactory implements AbstractProvider{

        @Override
        public SimpleFactory.Animal build() {
            return new SimpleFactory.Cat();
        }
    }

    public static class RealPigFactory implements AbstractProvider{

        @Override
        public SimpleFactory.Animal build() {
            return new SimpleFactory.Pig();
        }
    }
}
