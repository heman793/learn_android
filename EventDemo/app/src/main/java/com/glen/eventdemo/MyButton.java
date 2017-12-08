package com.glen.eventdemo;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * Created by heman on 17/11/22.
 */

public class MyButton extends AppCompatButton {
    private static String TAG = "Test-DEOM";

    public MyButton(Context context, AttributeSet set)
    {
        super(context,set);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        super.onKeyDown(keyCode,event);
        Log.i(TAG,"onKeyDown方法被调用" + event.getAction());
        Toast.makeText(getContext(), "onKeyDown方法被调用:" + event.getAction(),Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        super.onKeyUp(keyCode,event);
        Log.i(TAG,"onKeyUp方法被调用" + event.getAction());
        Toast.makeText(getContext(), "onKeyUp方法被调用:" + event.getAction(),Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        Log.i(TAG,"onTouchEvent方法被调用" + event.getAction());
        Toast.makeText(getContext(), "onTouchEvent方法被调用:" + event.getAction(),Toast.LENGTH_SHORT).show();
//        return true;
        //返回false，表示事件继续向外层(即父容器)扩散
        return false;
    }
}

