package com.glen.serivcedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by heman on 17/11/28.
 *
 * 调用StartService()启动Service
 */

public class TestServiceOne extends Service {

    private final String TAG = "TestServiceOne";

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"TestServiceOne.onBind方法被调用!");
        return null;
    }

    //服务第一次创建的时候调用
    @Override
    public void onCreate() {
        Log.i(TAG,"TestServiceOne.onCreate方法被调用!");
        super.onCreate();
    }

    //服务每一次启动的时候调用
    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        Log.i(TAG,"TestServiceOne.onStartCommand方法被调用!");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"TestServiceOne.onDestroy方法被调用");
        super.onDestroy();
    }
}
