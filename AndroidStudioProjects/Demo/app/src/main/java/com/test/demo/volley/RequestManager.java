package com.test.demo.volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by lizhi
 * 17-2-28
 */
public class RequestManager {

    private RequestQueue mRequestQueue;
    private static Context sContext;

    private RequestManager(){
    }

    public static class ManagerFactory{
        public static final RequestManager sManager = new RequestManager();
    }

    public static RequestManager getInstance(Context context){
        sContext = context.getApplicationContext();
        return ManagerFactory.sManager;
    }

    public RequestQueue getRequestQueue(){
        if(mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(sContext);
        }
        return mRequestQueue;
    }

}
