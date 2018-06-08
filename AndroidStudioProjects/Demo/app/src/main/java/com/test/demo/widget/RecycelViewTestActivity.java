package com.test.demo.widget;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.test.demo.R;

public class RecycelViewTestActivity extends Activity {

    private MyRecycleView recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycel_view_test);
        initView();
    }

    private void initView(){
        recycleView = findViewById(R.id.recycleView);
        MyLinearLayoutManager manager = new MyLinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycleView.setLayoutManager(manager);
        recycleView.setDrawingCacheEnabled(true);
        recycleView.setItemViewCacheSize(10);
        MyRecycleViewAdapter adapter = new MyRecycleViewAdapter();
        recycleView.setAdapter(adapter);
    }
}
