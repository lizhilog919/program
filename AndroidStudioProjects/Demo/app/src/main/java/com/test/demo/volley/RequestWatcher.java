package com.test.demo.volley;

import com.android.volley.Response;
import com.test.demo.retrofit.Repo;

import java.util.List;

/**
 * Created by lizhi
 * 17-2-28
 */
public interface RequestWatcher extends Response.ErrorListener {
    public void onSuccess(List<Repo> list);
}
