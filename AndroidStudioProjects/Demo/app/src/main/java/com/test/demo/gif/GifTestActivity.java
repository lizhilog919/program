package com.test.demo.gif;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.test.demo.R;

import pl.droidsonroids.gif.GifImageView;

public class GifTestActivity extends AppCompatActivity {

    private GifImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif_test);
        initView();
    }

    private void initView(){
        mImageView = (GifImageView) findViewById(R.id.gif);
        mImageView.setImageResource(R.drawable.gif_test);
    }

}
