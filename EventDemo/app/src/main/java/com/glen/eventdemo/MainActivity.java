package com.glen.eventdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnInnerClass = null;
    private Button btnInnerClass2 = null;
    private Button btnOuterClass = null;
    private TextView txtShow = null;
    private Button btnActivityClass = null;
    private Button btnBundleLabel = null;
    private Button btnOne = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInnerClass = (Button) findViewById(R.id.btnInnerClass);
        btnInnerClass2 = (Button) findViewById(R.id.btnInnerClass2);
        btnOuterClass = (Button) findViewById(R.id.btnOuterClass);
        txtShow = (TextView) findViewById(R.id.txtShow);
        btnActivityClass = (Button) findViewById(R.id.btnActivityClass);
        btnBundleLabel = (Button) findViewById(R.id.btnBundleLabel);
        btnOne = (Button) findViewById(R.id.btnOne);

        //方法一：使用内部类
        btnInnerClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点击<匿名内部类>按钮",Toast.LENGTH_SHORT).show();
            }
        });

        //方法二：使用内部类
        btnInnerClass2.setOnClickListener(new BtnClickListener());

        //方法三：使用外部类
        btnOuterClass.setOnClickListener(new MyEvent(txtShow));

        //方法四：直接使用Activity作为事件监听器
        btnActivityClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Event4Activity.class);
                startActivity(i);
            }
        });

        //方法五：直接绑定到标签:
        btnBundleLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Event5Activity.class);
                startActivity(i);
            }
        });

        //基于回调的事件处理机制-传播
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,EventCallBackActivity.class);
                startActivity(i);
            }
        });

    }

    //方法二：内部类
    class BtnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"点击<内部类>按钮",Toast.LENGTH_SHORT).show();
        }
    }



}
