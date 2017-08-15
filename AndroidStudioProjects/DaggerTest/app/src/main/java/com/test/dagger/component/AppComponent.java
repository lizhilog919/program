package com.test.dagger.component;

import android.app.Activity;
import android.content.Context;

import com.test.dagger.base.BaseActivity;
import com.test.dagger.module.AppModule;

import java.util.concurrent.ThreadPoolExecutor;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by Li Zhi
 * 2017/6/8.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(Activity activity);

    Context context();
}
