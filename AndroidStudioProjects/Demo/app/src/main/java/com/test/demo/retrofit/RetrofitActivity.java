package com.test.demo.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.test.demo.R;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        RetrofitUtil.doRequest();
    }

}
