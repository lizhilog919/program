package com.test.demo.glide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.test.demo.R;

public class GifTestActivity extends AppCompatActivity {

    private ImageView mImageView;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif_test);
        initView();
    }

    private void initView(){
        mImageView = (ImageView) findViewById(R.id.gif);
        mImage = (ImageView) findViewById(R.id.image);
        Glide.with(this).load("http://image.res.meizu.com/image/igrowth/5dbc237796a24cf8aee516fb3da3a8aez")
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mImageView);
    }
}
