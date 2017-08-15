package com.test.dagger;

import android.app.Application;

import com.test.dagger.component.AppComponent;
import com.test.dagger.component.DaggerActivityComponent;
import com.test.dagger.component.DaggerAppComponent;
import com.test.dagger.module.AppModule;

/**
 * Created by Li Zhi
 * 2017/6/8.
 */

public class DaggerApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }

    private void initializeInjector(){
        this.mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}
