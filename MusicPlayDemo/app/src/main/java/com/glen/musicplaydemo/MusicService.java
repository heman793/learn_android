package com.glen.musicplaydemo;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by heman on 17/11/30.
 *
 * 在播放状态发生改变时对外发送广播（广播将会激发前台 Activity 的 BroadcastReceiver）
 * 该 Service 也采用 BroadcastReceiver 监听来自前台 Activity 发出的广播
 */

public class MusicService extends Service {

    ServiceReceiver serviceReceiver;
    AssetManager am;
    String[] musics = new String[]{"wish.mp3","promise.mp3","beautiful.mp3"};
    MediaPlayer mediaPlayer;

    //当前状态：0x11-没有播放，0x12-正在播放，0x13-暂停
    int status = 0x11;

    //记录当前正在播放的音乐
    int current = 0;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        am = getAssets();

        //注册广播
        serviceReceiver = new ServiceReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(MainActivity.CTL_ACTION);
        registerReceiver(serviceReceiver,filter);

        mediaPlayer = new MediaPlayer();
        //为MediaPlayer播放完成事件绑定监听器，当MediaPlayer播放完成后将让它自动播放下一首歌曲
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                current++;
                if (current >= 3)
                {
                    current = 0;
                }
                //发送广播通知 Activity 更改文本框
                Intent sendIntent = new Intent(MainActivity.UPDATE_ACTION);
                sendIntent.putExtra("current",current);
                //发送广播，将被Activity组件中的 ActivityReceiver 接收到
                sendBroadcast(sendIntent);
                //准备并播放音乐
                prepareAndPlay(musics[current]);
            }
        });

        super.onCreate();
    }

    /**
     * 接收来自前台 Acitvity 所发出的广播，并根据广播的消息内容改变 Service 的播放状态
     * 当播放状态改变时，该 Service 对外发送一条广播，广播消息将会被前台 Acitvity 接收
     * 前台 Acitvity 将会根据广播消息去更新程序界面
     */
    public class ServiceReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"后台开始播放音乐",Toast.LENGTH_SHORT).show();
            int control = intent.getIntExtra("control",-1);
            switch (control)
            {
                //播放或暂停
                case 1:
                    if (status == 0x11)//原来处于没有播放状态
                    {
                        prepareAndPlay(musics[current]);//准备并播放音乐
                        status = 0x12;
                    }
                    else if (status == 0x12)//原来处于播放状态
                    {
                        mediaPlayer.pause();//暂停
                        status = 0x13;//改为暂停状态
                    }
                    else if (status == 0x13)//原来处于暂停状态
                    {
                        mediaPlayer.start();//播放
                        status = 0x12;//改变状态
                    }
                    break;
                //停止声音
                case 2:
                    //如果原来正在播放或暂停
                    if (status == 0x12 || status == 0x13)
                    {
                        mediaPlayer.stop();//停止播放
                        status = 0x11;
                    }
            }

            //广播通知Activity更改图标、广本框
            Intent sendIntent = new Intent(MainActivity.UPDATE_ACTION);
            sendIntent.putExtra("update",status);
            sendIntent.putExtra("current",current);
            //发送广播，将被Activity组件中的 ActivityReceiver 接收到
            sendBroadcast(sendIntent);
        }
    }

    //播放音乐
    private void prepareAndPlay(String music)
    {
        try
        {
            //打开指定音乐文件
            AssetFileDescriptor afd = am.openFd(music);
            mediaPlayer.reset();

            mediaPlayer.setDataSource(afd.getFileDescriptor(),
                    afd.getStartOffset(),
                    afd.getLength());

        }
        catch (IOException e )
        {
         e.printStackTrace();
        }
    }
}
