package com.test.demo.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.module.GlideModule;
import com.test.demo.TestApplication;

import java.io.InputStream;

/**
 * Created by lizhi
 * 17-2-21
 */
public class TestGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDecodeFormat(DecodeFormat.PREFER_RGB_565);
        builder.setBitmapPool(new LruBitmapPool(2048));
        builder.setDiskCache(new InternalCacheDiskCacheFactory(TestApplication.getContext()));
        builder.setMemoryCache(new LruResourceCache(2048));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        glide.register(String.class, InputStream.class, new ModelLoaderFactory<String, InputStream>() {
            @Override
            public ModelLoader<String, InputStream> build(Context context, GenericLoaderFactory factories) {
                return null;
            }

            @Override
            public void teardown() {

            }
        });
    }
}
