package com.test.dagger.module;

import android.content.Context;

import com.test.dagger.DaggerApplication;
import com.test.dagger.DbManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Li Zhi
 * 2017/6/8.
 */
@Module
public class AppModule {

    private final DaggerApplication mApplication;

    public AppModule(DaggerApplication daggerApplication){
        mApplication = daggerApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext(){
        return mApplication;
    }

    @Provides
    @Singleton
    DbManager provideDbManager(){
        return new DbManager(mApplication);
    }


}
