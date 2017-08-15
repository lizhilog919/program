package com.test.mvpdemo.di.component;

import android.app.Application;
import android.content.Context;

import com.test.mvpdemo.di.module.ApplicationModule;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

public class DragApplicationComponent implements ApplicationComponent {

    ApplicationModule mApplicationModule;

    public DragApplicationComponent(ApplicationModule module){
        mApplicationModule = module;
    }


    @Override
    public Application application() {
        return mApplicationModule.provideApplication();
    }

    @Override
    public Context context() {
        return mApplicationModule.provideContext();
    }
}
