package com.test.demo.framework;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.test.demo.BaseActivity;
import com.test.demo.R;

import java.util.List;

public class BluetoothActivity extends BaseActivity implements View.OnClickListener {

    BluetoothManager mBluetoothManager;
    BluetoothAdapter mBluetoothAdapter;
    List<BluetoothDevice> mDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        mBluetoothManager = getBluetoothManager();
        mBluetoothAdapter = mBluetoothManager.getAdapter();
        register();
    }

    private BluetoothManager getBluetoothManager(){
        return (BluetoothManager) getSystemService(BLUETOOTH_SERVICE);
    }

    private void startBluetooth(){
        if(mBluetoothAdapter == null){
            Toast.makeText(this,"not support bluetooth",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!mBluetoothAdapter.isEnabled()){
            mBluetoothAdapter.enable();
            Toast.makeText(this,"bluetooth has open",Toast.LENGTH_SHORT).show();
        }
    }

    private void stopBluetooth(){
        if(mBluetoothAdapter == null){
            Toast.makeText(this,"not support bluetooth",Toast.LENGTH_SHORT).show();
            return;
        }
        if(mBluetoothAdapter.isEnabled() && mBluetoothAdapter.getState() == BluetoothAdapter.STATE_ON){
            mBluetoothAdapter.disable();
            Toast.makeText(this,"bluetooth has close",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * bluetooth can be discovered in the time of duration
     * @param duration
     */
    private void ensureDiscoverable(int duration){
        if(mBluetoothAdapter == null){
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        if(mBluetoothAdapter == null){
            return;
        }
        if(mBluetoothAdapter.isEnabled() && mBluetoothAdapter.getScanMode() != BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE){
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            intent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,duration);
            startActivity(intent);
        }
    }

    private void register(){
        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        filter.addAction(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED);
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(searchDevices, filter);
    }

    private BroadcastReceiver searchDevices = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action)){
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                mDevices.add(device);
            }
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                startBluetooth();
                break;
            case R.id.stop:
                stopBluetooth();
                break;
        }
    }
}
