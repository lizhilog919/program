package com.test.demo.glide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.test.demo.R;

public class TestActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text:
                startActivity(new Intent(TestActivity.this, GifTestActivity.class));
                break;
        }
    }
}
