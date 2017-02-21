package com.test.demo;

import android.app.Application;
import android.content.Context;

/**
 * Created by lizhi
 * 17-2-21
 */
public class TestApplication extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context getContext(){
        return sContext;
    }
}
