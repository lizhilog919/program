package com.test.demo.eventbus;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.test.demo.BaseActivity;
import com.test.demo.R;

import org.greenrobot.eventbus.EventBus;

public class SendMessageActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.v("event_bus: ", "post thread: "+Thread.currentThread().getId());
                EventBus.getDefault().post(new MessageEvent("ha"));
                SendMessageActivity.this.finish();;
            }
        },2000);

    }
}
