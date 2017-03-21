package com.test.demo.remoteview;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

import com.test.demo.BaseActivity;
import com.test.demo.R;

public class NotificationActivity extends BaseActivity implements View.OnClickListener {

    RemoteViews mRemoteViews;
    Notification mNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        mNotification = createNotification();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.show:
                showNotification(mNotification);
                break;
        }
    }

    private Notification createNotification(){

        mRemoteViews = new RemoteViews("com.test.demo", R.layout.notification_remote);

        Intent intent = new Intent("COM.TEST.GIF");
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setContent(mRemoteViews);
        builder.setAutoCancel(true);

        Notification notification = builder.build();

        return notification;
    }

    private void showNotification(Notification notification){
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, notification);
    }

}
