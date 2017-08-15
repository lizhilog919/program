package com.test.dagger.module;

import android.app.Activity;

import com.test.dagger.base.ActivityScope;
import com.test.dagger.component.AppComponent;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Li Zhi
 * 2017/6/8.
 */
@Module
public class ActivityModule {
    private final Activity mActivity;

    public ActivityModule(Activity activity){
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity(){
        return mActivity;
    }
}
