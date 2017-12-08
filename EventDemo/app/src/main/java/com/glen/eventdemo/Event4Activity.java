package com.glen.eventdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 直接使用Activity作为事件监听器
 *      1、让Activity类实现XxxListener事件监听接口
        2、在Activity中定义重写对应的事件处理器方法
    eg:
        Actitity实现了OnClickListener接口,重写了onClick(view)方法
        在为某些组建添加该事件监听对象时直接setXxx.Listener(this)即可
 */

public class Event4Activity extends AppCompatActivity implements View.OnClickListener{

    private Button btnShow  = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event4);

        btnShow  = (Button) findViewById(R.id.btnShow);

        //直接写个this
        btnShow.setOnClickListener(this);
    }

    //重写接口中的抽象方法
    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(),"点击<直接使用Activity当监听>按钮",Toast.LENGTH_SHORT).show();
    }
}
