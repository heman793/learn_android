package com.glen.eventdemo;

import android.view.View;
import android.widget.TextView;

/**
 * Created by heman on 17/11/21.
 */

public class MyEvent implements View.OnClickListener {

    private TextView tvShow;

    //把文本框作为参数传入
    public MyEvent(TextView tv){
        this.tvShow = tv;
    }

    @Override
    public void onClick(View v) {
        //点击后设置文本框显示的文字
        tvShow.setText("点击<外部类>按钮");
    }
}
