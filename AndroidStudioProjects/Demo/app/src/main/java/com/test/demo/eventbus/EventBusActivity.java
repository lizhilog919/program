package com.test.demo.eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.test.demo.BaseActivity;
import com.test.demo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        EventBus.getDefault().register(this);
        Log.v("event_bus: ", "main thread: "+Thread.currentThread().getId());
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onEvent1(MessageEvent messageEvent){
        Log.v("event_bus: ", Thread.currentThread().getStackTrace()[2].getMethodName() + " : " +Thread.currentThread().getId());
        Toast.makeText(this,"on reacted: " + messageEvent.message,Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent2(MessageEvent messageEvent){
        Log.v("event_bus: ", Thread.currentThread().getStackTrace()[2].getMethodName() + " : "+Thread.currentThread().getId());
        Toast.makeText(this,"on reacted: " + messageEvent.message,Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEvent3(MessageEvent messageEvent){
        Log.v("event_bus: ", Thread.currentThread().getStackTrace()[2].getMethodName() + " : "+Thread.currentThread().getId());
        Toast.makeText(this,"on reacted: " + messageEvent.message,Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEvent4(MessageEvent messageEvent){
        Log.v("event_bus: ", Thread.currentThread().getStackTrace()[2].getMethodName() + " : "+Thread.currentThread().getId());
        Toast.makeText(this,"on reacted: " + messageEvent.message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text:
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(EventBusActivity.this, SendMessageActivity.class));
                    }
                },2000);
                break;
        }
    }
}
