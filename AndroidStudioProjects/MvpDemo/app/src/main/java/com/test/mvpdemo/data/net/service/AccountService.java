package com.test.mvpdemo.data.net.service;

import com.test.mvpdemo.data.model.User;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

public interface AccountService {

    @GET("/user")
    Observable<User> getUserInfo(@Query("access_token") String token);
}
