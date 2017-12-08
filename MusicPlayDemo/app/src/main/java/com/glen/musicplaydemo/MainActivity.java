package com.glen.musicplaydemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnPlay = null;
    private Button btnStop = null;
    private TextView tvTitle,tvAuthor = null;
    ActivityReceiver activityReceiver;

    public static final String CTL_ACTION="com.glen.action.CTL_ACTION";
    public static final String UPDATE_ACTION = "com.glen.action.UPDATE_ACTION";

    //定义音乐播放状态：0x11-没有播放，0x12-正在播放，0x13-暂停
    int status = 0x11;
    String[] titleList = new String[]{"First","Second","Third"};
    String[] authorList = new String[]{"Kobe","T-Mac","James"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取界面元素
        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnStop = (Button)findViewById(R.id.btnStop);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvAuthor = (TextView) findViewById(R.id.tvAuthor);

        //注册广播
        activityReceiver = new ActivityReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(UPDATE_ACTION);
        registerReceiver(activityReceiver,filter);

        //启动后台service
        Intent intent = new Intent(this,MusicService.class);
        startService(intent);

        //为按钮绑定单击事件监听器
        //按下播放/暂停按钮
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CTL_ACTION);
                intent.putExtra("control",1);
                //发送广播，将被Service组件中的 ServiceReceiver 接收到并根据control
                //来修改播放状态
                sendBroadcast(intent);
            }
        });

        //按下停止按钮
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CTL_ACTION);
                intent.putExtra("control",2);
                //发送广播，将被Service组件中的 ServiceReceiver 接收到并根据control
                //来修改播放状态
                sendBroadcast(intent);
            }
        });

    }

    /**
     *  自定义BroadcastReceiver，负责监听从Service传回来的广播
     *  根据广播Intent里的消息来修改播放状态，并更新程序界面中的按钮围标：
     *  1、当正在播放时，显示暂停围标：
     *  2、当正在暂停时，显示播放围标。
     *  并根据传回来的current数据来更新title、author两个文本框显示的文本
     */
    public class ActivityReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"前台修改显示信息",Toast.LENGTH_SHORT).show();

            //获取 Intent 中的 update 消息，update代表播放状态
            int update = intent.getIntExtra("update",-1);
            //获取 Intent 中的 current 消息，current代表当前下在播放的歌曲
            int current =  intent.getIntExtra("current",-1);

            if(current >= 0)
            {
                tvTitle.setText(titleList[current]);
                tvAuthor.setText(authorList[current]);
            }

            switch (update)
            {
                case 0x11:
                    btnPlay.setText("播放1");
                    status = 0x11;
                    break;
                //控制系统进入播放状态
                case 0x12:
                    //播放状态下设置使用暂停围标
                    btnPlay.setText("暂停1");
                    status = 0x12;  //设置当前状态
                    break;
                //控制系统进入暂停状态
                case 0x13:
                    //暂停状态下设置使用播放围标
                    btnPlay.setText("播放1");
                    status=0x13; //设置当前状态
                    break;
            }

        }
    }
}
