package com.test.mvpdemo.di.module;

import com.test.mvpdemo.data.api.AccountApi;
import com.test.mvpdemo.data.net.AccountDataSource;

import dagger.Module;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

@Module
public class AccountModule {
    AccountApi provideAccountApi(AccountDataSource dataSource){
        return dataSource;
    }
}
