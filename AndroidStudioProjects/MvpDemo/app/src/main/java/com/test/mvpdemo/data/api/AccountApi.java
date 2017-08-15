package com.test.mvpdemo.data.api;

import com.test.mvpdemo.data.model.User;

import java.util.Observable;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

public interface AccountApi {
    rx.Observable<User> login(String name, String password);
}
