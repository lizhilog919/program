package com.test.mvpdemo.di.module;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity){
        mActivity = activity;
    }

    public ActivityModule(Fragment fragment){
        mActivity = fragment.getActivity();
    }

    @Provides
    public Activity provideActivity(){
        return mActivity;
    }

    @Provides
    public Context provideContext(){
        return mActivity;
    }
}

