package com.test.demo.widget;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.test.demo.R;

import java.util.ArrayList;
import java.util.List;

public class ScrollViewActivity extends AppCompatActivity {

    ViewPager mViewPager;
    PagerAdapter mAdapter;
    List<String> mUrls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        initView();
    }

    private void initView(){
        mUrls = new ArrayList<>();
        mUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491408941400&di=2bc6ef892efd2ca855ae4034f9849e0a&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F13%2F60%2F91%2F42P58PIChDU_1024.jpg");
        mUrls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491408941401&di=48750a3b52f0997173e13b0483f6d447&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F13%2F60%2F91%2F06B58PICePi_1024.jpg");
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mAdapter = new MyAdapter();
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(mAdapter.getCount()/2);
    }

    public class MyAdapter extends PagerAdapter{


        @Override
        public int getCount() {
            return mUrls.size() * 10;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(container.getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(container.getContext()).load(mUrls.get(position % mUrls.size())).into(imageView);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
        }
    }
}
