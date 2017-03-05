package com.test.demo.okhttp;

import android.util.Log;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;

/**
 * Created by lizhi
 * 16-12-20
 */
public class OkHttpUtil {
    public static final String TAG= OkHttpUtil.class.getSimpleName();

    private static Response getGslbResponse(Request request){
        Response.Builder builder = new Response.Builder();
        builder.headers(request.headers());
        builder.addHeader("name", "lizhi");
        builder.code(205);
        ResponseBody body = ResponseBody.create(MediaType.parse("UTF-8"),"content");
        builder.body(body);
        return builder.build();
    }

    public static void executeRequest(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("name","lizhi").build();
                Response response = chain.proceed(request);
                return response.newBuilder().code(205).build();
            }
        });
        builder.authenticator(new Authenticator() {
            @Override
            public Request authenticate(Route route, Response response) throws IOException {
                //401情况下触发
                //FIXME: 17-1-19
                //TODO 获取最新token
                FormBody requestBody = (FormBody) response.request().body();
                FormBody.Builder builder = new FormBody.Builder();
                for (int i = 0; i < requestBody.size(); i++) {
                    if (requestBody.name(i).equals("access_token")) {
                        builder.add(requestBody.name(i), "");
                    } else {
                        builder.add(requestBody.name(i), requestBody.value(i));
                    }
                }
                Request.Builder requestBuilder = response.request().newBuilder().method(response.request().method(), builder.build());
                return requestBuilder.build();
            }
        });
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.cacheControl(new CacheControl.Builder().onlyIfCached().build());
        HttpUrl.Builder httpBuilder = new HttpUrl.Builder();
        httpBuilder.scheme("https").host("member.meizu.com").addPathSegment("/uc/oauth/memberplusinfo/getdeliveryaddresslist");
        requestBuilder.url(httpBuilder.build());
        Call call = builder.build().newCall(requestBuilder.build());
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.v(TAG, e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Log.v(TAG, result);
            }
        });
    }

}
