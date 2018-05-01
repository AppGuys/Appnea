package com.example.mads.appnea;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class SyncService extends Service {

    private final IBinder myBinder = new BindService();


    public SyncService() {
    }

    public class BindService extends Binder {
        SyncService getService(){
            return SyncService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
