package com.test.mvpdemo.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

@Module
public class ApplicationModule {

    protected final Application mApplication;

    public ApplicationModule(Application application){
        mApplication = application;
    }

    @Provides
    public Application provideApplication(){
        return mApplication;
    }

    @Provides
    public Context provideContext(){
        return mApplication;
    }

}
