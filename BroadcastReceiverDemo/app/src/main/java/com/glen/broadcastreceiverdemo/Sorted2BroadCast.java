package com.glen.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by heman on 17/11/30.
 *
 * 发送有序广播-第二个接收者
 */

public class Sorted2BroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("SendBroadCast","有序广播-second");


        Bundle b = getResultExtras(true);

        //解析前一个BroadcastReceiver(SortedBroadCast)所存入的key为first的数据
        String first = b.getString("first");
        Toast.makeText(context,
                "第一个接收者存入的消息为："+first,
                Toast.LENGTH_LONG).show();

    }
}
