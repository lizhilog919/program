package com.test.demo.aidl;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.test.demo.R;

import java.util.List;

public class AidlActivity extends AppCompatActivity {

    IDogManager mService;
    TextView mTextView;
    List<Dog> list;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mTextView.setText(list.get(0).getNum()+"");
        }
    };

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            try {
                mService = IDogManager.Stub.asInterface(service);
                Dog dog = new Dog();
                dog.setNum(10);
                mService.addDog(dog);
                list = mService.getDogList();
                mHandler.sendEmptyMessage(0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        mTextView = (TextView) findViewById(R.id.text);
        Intent intent = new Intent(this, RouteService.class);
        bindService(intent, mServiceConnection, Service.BIND_AUTO_CREATE);
    }

}
