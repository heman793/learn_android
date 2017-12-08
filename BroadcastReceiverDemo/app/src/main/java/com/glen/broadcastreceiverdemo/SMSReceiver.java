package com.glen.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by heman on 17/11/30.
 *
 * 短信拦截器
 */

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("SMSReceiver", "短信拦截");
        Toast t = Toast.makeText(context,"短信拦截",Toast.LENGTH_LONG);
        t.setGravity(Gravity.BOTTOM,0,0);
        t.show();
    }
}
