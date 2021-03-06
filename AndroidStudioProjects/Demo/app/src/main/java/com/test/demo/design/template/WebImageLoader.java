package com.test.demo.design.template;

/**
 * Created by Li Zhi
 * 2017/3/9.
 */

public class WebImageLoader extends ImageLoader {
    @Override
    protected String getUrl(String url, int width, int height) {
        return String.format("%s?imageView2/1/w/%d/h/%d/format/webp", url, width, height);
    }
}
