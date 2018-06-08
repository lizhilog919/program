package com.test.demo.widget;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.demo.R;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public static final String TAG = "XXXX";

    private String[] str = {"这是第1个","这是第2个","这是第3个","这是第4个","这是第5个","这是第6个","这是第7个","这是第8个","这是第9个","这是第10个","这是第11个"};

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_recycle_item, null);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(str[position]);
        Log.v(TAG, "position: " + position);
    }

    @Override
    public int getItemCount() {
        return str.length;
    }
}
