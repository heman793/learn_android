package com.glen.broadcastreceiverdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    TestBRReceiver testBR;
    CallReceiver callBR;

    private Button btnSendBroadcast = null;
    private Button btnSendOrderBroadcast = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //动态注册广播
        testBR = new TestBRReceiver();
        //广播-网络状态监测
        IntentFilter iFilter = new IntentFilter();
        iFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(testBR,iFilter);

        //发送普通广播
        btnSendBroadcast = (Button) findViewById(R.id.btnSendBroadcast);
        btnSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction("com.glen.action.TEST_BROADCAST");//此action已经在xml文件注册
                i.putExtra("msg","测试-发送普通广播消息");
                //发送普通广播
                sendBroadcast(i);
            }
        });

        //发送有序广播
        btnSendOrderBroadcast = (Button) findViewById(R.id.btnSendOrderBroadcast);
        btnSendOrderBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction("com.glen.action.TEST_ORDED_BROADCAST");//此action已经在xml文件注册
                i.putExtra("msg","测试-发送有序广播消息");
                //发送有序广播
                sendOrderedBroadcast(i,null);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //取消广播注册,优化内存空间，避免内存溢出
        unregisterReceiver(testBR);
        unregisterReceiver(callBR);
    }
}
