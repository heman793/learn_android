package com.glen.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by heman on 17/11/30.
 *
 * 发送普通广播
 */

public class SendBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("SendBroadCast","普通广播");
        Toast.makeText(context,
                "接收到的 Intent 的 Action 为："+intent.getAction()+"\n消息内容是："+ intent.getStringExtra("msg"),
                Toast.LENGTH_LONG).show();

       }
}
