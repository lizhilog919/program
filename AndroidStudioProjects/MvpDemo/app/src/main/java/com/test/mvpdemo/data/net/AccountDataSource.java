package com.test.mvpdemo.data.net;

import com.test.mvpdemo.data.api.AccountApi;
import com.test.mvpdemo.data.model.User;

import rx.Observable;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

public class AccountDataSource implements AccountApi {
    @Override
    public Observable<User> login(String name, String password) {
        // do service request
        return null;
    }
}
