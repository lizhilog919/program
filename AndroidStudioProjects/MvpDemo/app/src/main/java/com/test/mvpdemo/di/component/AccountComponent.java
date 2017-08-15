package com.test.mvpdemo.di.component;

import com.test.mvpdemo.di.module.ActivityModule;
import com.test.mvpdemo.ui.module.account.LoginActivity;

import dagger.Component;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

@Component(dependencies = ActivityComponent.class, modules = {ActivityModule.class, })
public interface AccountComponent extends ActivityComponent {
    void inject(LoginActivity loginActivity);
}
