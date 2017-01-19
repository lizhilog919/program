package com.test.demo.retrofit;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by lizhi
 * 17-1-19
 */
public class RetrofitUtil {

    public static void doRequest(){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://api.github.com/");
        //builder.addConverterFactory(new GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        RequestService requestService = retrofit.create(RequestService.class);
        retrofit2.Call<List<Repo>> repos = requestService.getRepoList("lizhilog919");
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                Log.v("xx","xx");
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.v("xx","error");
            }
        });
    }
}
