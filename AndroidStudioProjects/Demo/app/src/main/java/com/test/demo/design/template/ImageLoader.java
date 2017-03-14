package com.test.demo.design.template;

/**
 * 模板方法
 * Created by Li Zhi
 * 2017/3/9.
 */

public abstract class ImageLoader {

    public final void downloadImage(String url, int width, int height){
        String final_imageUrl = getUrl(url, width,height);
    }

    protected abstract String getUrl(String url,int width, int height);
}
