package com.test.demo.design.prototype;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by lizhilog0919 on 2017/3/9.
 */

public class PrototypeTest {

    public static void main(String[] args){
        RealObject realObject = new RealObject(3);
        NormalObject originNormalObject = realObject.getNormalObject();
        RealObject cloneObject = (RealObject) realObject.clone();
        cloneObject.show();
        //NormalObject没有而被拷贝，依然是原始对象
        NormalObject normalObject = cloneObject.getNormalObject();
        normalObject.show();


        System.out.println("浅拷贝： " + String.valueOf(normalObject.equals(originNormalObject)));

        try {
            RealObject deepCloneObject = (RealObject) realObject.deepClone();
            //深拷贝 normalObject引用变量指向的对象也被重新创建
            NormalObject normalObject1 = deepCloneObject.getNormalObject();
            System.out.println("深拷贝： " + String.valueOf(normalObject1.equals(originNormalObject)));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //NormalObject normalObject = new NormalObject(5);
        //因为clone是protected的，所以外部包无法调用
        //NormalObject clone = normalObject.clone();
    }

    public static class RealObject extends Prototype{

        private int num;
        private NormalObject mNormalObject;

        public RealObject(int num){
            this.num = num;
            mNormalObject = new NormalObject(6);
        }

        public NormalObject getNormalObject() {
            return mNormalObject;
        }

        public void show(){
            System.out.println(String.valueOf(num));
        }
    }

    public static class NormalObject implements Serializable{
        private int num;

        public NormalObject(int num){
            this.num = num;
        }

        public void show(){
            System.out.println(String.valueOf(num));
        }
    }
}
