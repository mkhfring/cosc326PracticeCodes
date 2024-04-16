package com.example.backgroundserviceincalsspractice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyBackgroundService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("bgServicec", "The service is running");
//        new Thread(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        while (true){
//                        Log.e("bgServicec", "The service is running");
//                        try {
//                            Thread.sleep(3000);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                }}
//        ).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
