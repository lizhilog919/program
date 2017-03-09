package com.test.demo.design.factory;

/**
 * Created by lizhilog0919 on 2017/3/9.
 */

public class FactoryTest {

    public static void main(String[] args){
        SimpleFactory simpleFactory = new SimpleFactory();
        SimpleFactory.Animal cat = simpleFactory.getAnimal(0);

        SimpleFactory.Animal pig = SimpleFactory.getPig();

        SimpleFactory.Animal cat1 = new AbstractFactory.RealCatFactory().build();

        SimpleFactory.Animal dog = new RealDogFactory().build();
    }

    public static class Dog implements SimpleFactory.Animal{

        @Override
        public String type() {
            return "DOG_TYPE";
        }
    }

    public static class RealDogFactory implements AbstractFactory.AbstractProvider{

        @Override
        public SimpleFactory.Animal build() {
            return new Dog();
        }
    }
}
