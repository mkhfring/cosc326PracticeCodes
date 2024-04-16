package com.example.foregroundseriveinclasspractice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class ForeGroundService extends Service {
    String ChannelId = "Foreground service";
    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("fgService", "The foreground service is running");
        Notification notification = createNotification();
        startForeground(100, notification);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void createNotificationChannel(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    ChannelId, ChannelId, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Foreground service notification");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
    public Notification createNotification(){
        return new NotificationCompat.Builder(this, ChannelId)
                .setContentTitle("Foreground Service")
                .setContentText("The service is running")
                .setSmallIcon(R.drawable.ic_launcher_background).build();
    }
}
