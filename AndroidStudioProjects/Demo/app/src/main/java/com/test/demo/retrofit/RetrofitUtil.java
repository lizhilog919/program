package com.test.demo.retrofit;

import android.util.Log;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lizhi
 * 17-1-19
 */
public class RetrofitUtil {

    public static void doRequest(){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://api.github.com/");
        builder.client(new OkHttpClient());
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        Retrofit retrofit = builder.build();
        RequestService requestService = retrofit.create(RequestService.class);
        Call<List<Repo>> call = requestService.getRepoList("lizhilog919");
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                Log.v("xx", "xx");
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.v("xx", "xx");
            }
        });

       /* Observable<List<Repo>> r = requestService.getRepoList2("lizhilog919");
        r.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<List<Repo>, List<Repo>>() {
                    @Override
                    public List<Repo> call(List<Repo> repos) {
                        for (int i = 0; i < repos.size(); i++) {
                            repos.get(i).extension = i + 100;
                        }
                        return repos;
                    }
                })
                .subscribe(new Subscriber<List<Repo>>() {
                    @Override
                    public void onCompleted() {
                        Log.v("xx", "xx");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.v("xx", "xx");
                    }

                    @Override
                    public void onNext(List<Repo> repos) {
                        Log.v("xx", "xx");
                    }
                });*/
    }
}
