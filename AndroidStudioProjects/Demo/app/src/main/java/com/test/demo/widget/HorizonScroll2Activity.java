package com.test.demo.widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.test.demo.R;

import java.util.ArrayList;
import java.util.List;

public class HorizonScroll2Activity extends AppCompatActivity {

    HorizontalEx2 mHorizontalEx;
    List<ListViewEx2> mListViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizon_scroll2);
        initView();
    }

    private void initView(){
        mHorizontalEx = (HorizontalEx2) findViewById(R.id.scrollView);
        mListViews = new ArrayList<>();
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            data.add("data: " + i);
        }
        for (int i = 0; i < 3; i++) {
            ListViewEx2 listView = new ListViewEx2(this);
            ViewGroup.LayoutParams params= new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            listView.setLayoutParams(params);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
            listView.setAdapter(adapter);
            listView.setHorizontalEx2(mHorizontalEx);
            mHorizontalEx.addView(listView);
        }
    }
}
