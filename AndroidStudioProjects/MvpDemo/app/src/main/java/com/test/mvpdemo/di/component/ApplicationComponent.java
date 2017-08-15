package com.test.mvpdemo.di.component;

import android.app.Application;
import android.content.Context;

import com.test.mvpdemo.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Application application();

    Context context();
}
