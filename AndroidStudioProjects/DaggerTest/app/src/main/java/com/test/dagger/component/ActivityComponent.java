package com.test.dagger.component;

import android.app.Activity;
import android.app.LauncherActivity;

import com.test.dagger.base.ActivityScope;
import com.test.dagger.module.ActivityModule;

import dagger.Component;

/**
 * Created by Li Zhi
 * 2017/6/8.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();

    void inject(Activity activity);

}
