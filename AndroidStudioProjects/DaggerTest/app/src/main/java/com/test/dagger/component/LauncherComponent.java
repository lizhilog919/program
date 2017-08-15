package com.test.dagger.component;


import com.test.dagger.base.ActivityScope;
import com.test.dagger.module.LauncherModule;
import com.test.dagger.ui.LauncherActivity;

import dagger.Component;

/**
 * Created by Li Zhi
 * 2017/6/25.
 */

@Component(modules = LauncherModule.class)
public interface LauncherComponent {
    void inject(LauncherActivity launcherActivity);
}
