package com.glen.uielementdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnTV = null;
    private Button btnAdapter = null;
    private Button btnAdapter2 = null;
    private Button btnSimpleAdapter = null;
    private Button btnSCAdapter = null;
    private Button btnListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTV = (Button) findViewById(R.id.btnTV);
        btnAdapter = (Button) findViewById(R.id.btnAdapter);
        btnAdapter2 = (Button) findViewById(R.id.btnAdapter2);
        btnSimpleAdapter = (Button) findViewById(R.id.btnSimpleAdapter);
        btnSCAdapter = (Button) findViewById(R.id.btnSCAdapter);
        btnListView = (Button) findViewById(R.id.btnListView);

        btnTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TextViewActivity.class);
                startActivity(i);
            }
        });

        btnAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AdapterActivity.class);
                startActivity(i);
            }
        });

        btnAdapter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Adapter2Activity.class);
                startActivity(i);
            }
        });

        btnSimpleAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SimpleAdapterActivity.class);
                startActivity(i);
            }
        });

        btnSCAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SimpleCursorAdapterActivity.class);
                startActivity(i);
            }
        });


        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListViewDemoActivity.class);
                startActivity(i);
            }
        });
    }

}