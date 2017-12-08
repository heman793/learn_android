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
 * 发送有序广播-第一个接收者
 */

public class SortedBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("SendBroadCast","有序广播-first");

        Toast.makeText(context,
                "接收到的 Intent 的 Action 为："+intent.getAction()+"\n消息内容是："+ intent.getStringExtra("msg"),
                Toast.LENGTH_LONG).show();

        //new 一个Bundle对象并存入数据
        Bundle b = new Bundle();
        b.putString("first","from first broadcast");
        //将bundle放入结果中
        setResultExtras(b);

        //终止BroadCast的继续传播，优先级比SortedBroadCast低的接收者都不会被触发
        //注释掉后：Sorted2BroadCast 才会被触发
//        abortBroadcast();
    }
}

