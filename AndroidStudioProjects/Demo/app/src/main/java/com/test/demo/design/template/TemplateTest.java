package com.test.demo.design.template;

/**
 * Created by Li Zhi
 * 2017/3/9.
 */

public class TemplateTest {

    public static void main(String[] args){
        ImageLoader imageLoader = new WebImageLoader();
        imageLoader.downloadImage("http://www.iamge.com/test.jpg",300,400);
    }
}
