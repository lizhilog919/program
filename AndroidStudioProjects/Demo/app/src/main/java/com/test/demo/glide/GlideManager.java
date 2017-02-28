package com.test.demo.glide;

/**
 * Created by lizhi
 * 17-2-24
 */
public class GlideManager {

    private GlideManager(){}

    public static class GlideManagerHolder{
        public static final GlideManager instance = new GlideManager();
    }

    public static GlideManager getInstance(){
        return GlideManagerHolder.instance;
    }
}
