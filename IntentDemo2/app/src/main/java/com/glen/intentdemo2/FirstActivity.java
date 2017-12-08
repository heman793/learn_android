package com.glen.intentdemo2;

import android.content.ComponentName;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        TextView textShow = (TextView) findViewById(R.id.textShow);

        //获取该 Activity 对应的 Intent的 Component 属性
        ComponentName cn = getIntent().getComponent();

        textShow.setText("组件包名为：" + cn.getPackageName()
                + "\n组件类名为：" + cn.getClassName());
    }

}
