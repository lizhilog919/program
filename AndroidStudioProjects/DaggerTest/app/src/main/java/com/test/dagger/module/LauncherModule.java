package com.test.dagger.module;

import com.test.dagger.data.LauncherApp;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Li Zhi
 * 2017/6/25.
 */
@Module
public class LauncherModule {

    @Provides
    LauncherApp getLauncherApp(){
        return new LauncherApp();
    }

}
