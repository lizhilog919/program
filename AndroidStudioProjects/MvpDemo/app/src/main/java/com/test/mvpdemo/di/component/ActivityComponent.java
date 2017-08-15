package com.test.mvpdemo.di.component;

import android.app.Activity;

import com.test.mvpdemo.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
