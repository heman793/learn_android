package com.glen.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnOne = null;
    private Button btnTwo = null;
    private Button btnThird = null;
    private Button btnFour = null;
    private Button btnFive = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = (Button)findViewById(R.id.btnOne);
        btnTwo = (Button)findViewById(R.id.btnTwo);
        btnThird = (Button)findViewById(R.id.btnThird);
        btnFour = (Button)findViewById(R.id.btnFour);
        btnFive = (Button)findViewById(R.id.btnFive);

        //返回主界面
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setAction(Intent.ACTION_MAIN);
                it.addCategory(Intent.CATEGORY_HOME);
                startActivity(it);
            }
        });

        //打开任意网址
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setAction(Intent.ACTION_VIEW);
                it.setData(Uri.parse("http://www.cnblogs.com/puresoul"));
                startActivity(it);
            }
        });

        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setAction(Intent.ACTION_VIEW);
                startActivity(it);
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setAction("myaction");
                it.addCategory("mycategory");
                startActivity(it);
            }
        });

        //打电话
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:18520858180");
                Intent it = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(it);
            }
        });
    }
}
