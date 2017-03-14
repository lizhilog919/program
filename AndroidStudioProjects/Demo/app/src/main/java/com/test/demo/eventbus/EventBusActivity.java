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

    @Subscribe
    public void onEvent(MessageEvent messageEvent){
        Log.v("event_bus: ", "receiver thread onEvent: "+Thread.currentThread().getId());
        Toast.makeText(this,"on reacted: " + messageEvent.message,Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void onEventMainThread(MessageEvent messageEvent){
        Log.v("event_bus: ", "receiver thread onEventMainThread: "+Thread.currentThread().getId());
        Toast.makeText(this,"on reacted: " + messageEvent.message,Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void onEventBackgroundThread(MessageEvent messageEvent){
        Log.v("event_bus: ", "receiver thread onEventBackgroundThread: "+Thread.currentThread().getId());
        Toast.makeText(this,"on reacted: " + messageEvent.message,Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void onEventSync(MessageEvent messageEvent){
        Log.v("event_bus: ", "receiver thread onEventSync: "+Thread.currentThread().getId());
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
