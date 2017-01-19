package com.test.demo.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lizhi
 * 17-1-19
 */
public interface RequestService {

    @GET("users/{user}/repos")
    Call<List<Repo>> getRepoList(@Path("user") String user);

}
