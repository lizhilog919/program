package com.test.demo.glide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.test.demo.R;

public class GlideFragment extends Fragment {

    private ImageView mImageView;
    private ImageView mImage;

    public static GlideFragment newInstance() {
        GlideFragment fragment = new GlideFragment();
        return fragment;
    }

    public GlideFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_glide, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View root){
        mImageView = (ImageView) root.findViewById(R.id.gif);
        mImage = (ImageView) root.findViewById(R.id.image);
        Glide.with(this).load("http://image.res.meizu.com/image/igrowth/5dbc237796a24cf8aee516fb3da3a8aez")
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mImageView);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), TestActivity.class));
            }
        });
    }
}
