package com.test.mvpdemo;

import android.app.Application;
import android.content.Context;

import com.test.mvp.BaseMvpPresenter;
import com.test.mvpdemo.di.component.ApplicationComponent;
import com.test.mvpdemo.di.component.DragApplicationComponent;
import com.test.mvpdemo.di.module.ApplicationModule;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

public class MvpDemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    ApplicationComponent mApplicationComponent;

    public static MvpDemoApplication getApplication(Context context){
        return (MvpDemoApplication) context.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent() {
        if(mApplicationComponent == null){
            mApplicationComponent = new DragApplicationComponent(new ApplicationModule(this));
        }
        return mApplicationComponent;
    }

    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
