package com.test.demo.retrofit;

import android.util.Log;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
        Observable<List<Repo>> r = requestService.getRepoList2("lizhilog919");

        r.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
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
                });
    }
}
