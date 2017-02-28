package com.test.demo.volley;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.test.demo.R;
import com.test.demo.retrofit.Repo;

import java.util.List;

public class VolleyTestActivity extends AppCompatActivity {

    RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_test);
        mRequestQueue = RequestManager.getInstance(getApplicationContext()).getRequestQueue();
        RepoRequest repoRequest = new RepoRequest(Request.Method.GET, "https://api.github.com/users/lizhilog919/repos", new RequestWatcher() {
            @Override
            public void onSuccess(List<Repo> list) {
                Log.v("xx","xx");
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("xx","xx");
            }
        });
        mRequestQueue.add(repoRequest);
    }

}
