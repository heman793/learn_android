package com.glen.brlogindemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;


/**
 * 代码示例-别处登陆踢用户下线
 * 像微信一样，正在运行的微信，如果我们用别的手机再次登陆自己的账号，前面这个是会提醒账户
 * 在别的终端登录这样，然后把我们打开的所有Activity都关掉，然后回到登陆页面这样~
 *
 */
public class MainActivity extends BaseActivity {

    private MyBcReceiver receiver;
    private LocalBroadcastManager localBroadcastManager;
    private IntentFilter intentFilter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册本地广播--动态注册
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        receiver = new MyBcReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.glen.mybcreveiver.LOGIN_DEMO");
        localBroadcastManager.registerReceiver(receiver,intentFilter);

        //按钮注册绑定事件-发送广播
        Button btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.glen.mybcreveiver.LOGIN_DEMO");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    //取消注册--动态注册的必须手动取消，否则会造成内存溢出
    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(receiver);
    }
}
