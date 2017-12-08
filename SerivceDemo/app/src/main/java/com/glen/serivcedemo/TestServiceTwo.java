package com.glen.serivcedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by heman on 17/11/28.
 *
 * 调用bindService()启动Service
 */

public class TestServiceTwo extends Service {

    private final String TAG = "TestServiceTwo";


    //创建自己的绑定服务业务逻辑
   public class MyBinder extends Binder{
        public void read(){
            Log.i(TAG,"***** read method ******");
        }
        public void play(){
            Log.i(TAG,"***** play method ******");
        }
    }

    private MyBinder mb = new MyBinder();

//*************************************************//

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"TestServiceTwo.onBind方法被调用!");
        Toast.makeText(this,"TestServiceTwo.onBind方法被调用",Toast.LENGTH_SHORT).show();
        return mb;
    }

    //服务第一次创建的时候调用
    @Override
    public void onCreate() {
        Log.i(TAG,"TestServiceTwo.onCreate方法被调用!");
        Toast.makeText(this,"TestServiceTwo.onCreate方法被调用",Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    //服务每一次启动的时候调用
    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        Log.i(TAG,"TestServiceTwo.onStartCommand方法被调用!");
        Toast.makeText(this,"TestServiceTwo.onStartCommand方法被调用",Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"TestServiceTwo.onDestroy方法被调用");
        Toast.makeText(this,"TestServiceTwo.onDestroy方法被调用",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }


}
