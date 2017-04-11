package com.test.demo.framework;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.res.AssetManager;
import android.os.PowerManager;
import android.os.storage.StorageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;

import com.test.demo.R;

public class FrameworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framework);
    }

    private void testResourceManager(){
        AssetManager assetManager = getResources().getAssets();
    }

    private void testActivityManager(){
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
    }

    private void testPowerManager(){
        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
    }

    private void testWindowManager(){
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        getWindowManager();
    }

    private void testLayoutInflater(){
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
    }

    private void testAccountManager(){
        AccountManager accountManager = (AccountManager) getSystemService(ACCOUNT_SERVICE);
    }

    private void testAlarmManager(){
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    private void testNotificationManager(){
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    private void testAccessibilityManager(){
        AccessibilityManager accessibilityManager = (AccessibilityManager) getSystemService(ACCESSIBILITY_SERVICE);
    }

    private void testStorageManager(){
        StorageManager storageManager = (StorageManager) getSystemService(STORAGE_SERVICE);
    }

    private void testBluetoothManager(){
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(BLUETOOTH_SERVICE);
        BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();
    }
}
