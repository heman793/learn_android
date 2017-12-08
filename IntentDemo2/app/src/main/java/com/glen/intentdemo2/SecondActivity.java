package com.glen.intentdemo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Set;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textShow = (TextView) findViewById(R.id.textShow);
        TextView textShowCate = (TextView) findViewById(R.id.textShowCate);

        //获取该 Activity 对应的 Intent 的 Action 属性
        String action = getIntent().getAction();

        //获取该 Activity 对应的 Intent 的 Categorie 属性
        Set<String> cates = getIntent().getCategories();

        textShow.setText("Action为：" + action);
        textShowCate.setText("Category为：" + cates);


    }
}
