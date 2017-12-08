package com.glen.serivcedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnStart = null;
    private Button btnStop = null;
    private Button btnBind = null;
    private Button btnUnbind = null;
    private TestServiceTwo.MyBinder mb;

    //创建ServiceConnection,在绑定服务的时候会用到
    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mb = (TestServiceTwo.MyBinder)service;  //类型转换
            //指挥服务需要做的工作
            mb.read();
            mb.play();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnBind = (Button) findViewById(R.id.btnBind);
        btnUnbind = (Button) findViewById(R.id.btnUnbind);


        Intent it1 = new Intent(MainActivity.this,TestServiceThree.class);
        Bundle b1 = new Bundle();
        b1.putString("param", "s1");
        it1.putExtras(b1);

        Intent it2 = new Intent(MainActivity.this,TestServiceThree.class);
        Bundle b2 = new Bundle();
        b2.putString("param", "s2");
        it2.putExtras(b2);

        Intent it3 = new Intent(MainActivity.this,TestServiceThree.class);
        Bundle b3 = new Bundle();
        b3.putString("param", "s3");
        it3.putExtras(b3);

        //接着启动多次IntentService,每次启动,都会新建一个工作线程
        //但始终只有一个IntentService实例
        startService(it1);
        startService(it2);
        startService(it3);



//
//        //启动服务
//        btnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,TestServiceOne.class);
//                //开启服务
//                startService(i);
//            }
//        });
//
//        //停止服务
//        btnStop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,TestServiceOne.class);
//                //停止服务
//                stopService(i);
//            }
//        });
//
//        //绑定服务
//        btnBind.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,TestServiceTwo.class);
//                bindService(i,sc,BIND_AUTO_CREATE);
//            }
//        });
//
//        //解除绑定服务
//        btnUnbind.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,TestServiceTwo.class);
//                unbindService(sc);
//            }
//        });

    }
}
