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
 * 电话广播
 */

public class CallReceiver extends BroadcastReceiver {

    private final String TAG = "CallReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "打电话");
        Toast t = Toast.makeText(context,"打电话",Toast.LENGTH_LONG);
        t.setGravity(Gravity.BOTTOM,0,0);
        t.show();

         //获取电话号码
        String iphone = getResultData();
        Log.i(TAG, "电话号码：" + iphone);
        //添加IP段
        String newPhone = "+86" + iphone;
        //把修改后的号码放回去
        setResultData(newPhone);
    }
}
