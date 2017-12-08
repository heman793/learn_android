package com.glen.androidlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnOne = null;
    private Button btnTwo = null;
    private Button btnThree = null;
    private Button btnFour = null;
    private Button btnFive = null;
    private Button btnSix = null;
    private Button btnSeven = null;
    private Button btnEight = null;
    private Button btnNine = null;
    private Button btnTen = null;
    private Button btnEleven = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnTen = (Button) findViewById(R.id.btnTen);
        btnEleven = (Button) findViewById(R.id.btnEleven);


        //跳转activity2(weight属性详解-用wrap_content,直接就按比例)
        btnOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, SeconeActivity.class);
                startActivity(i);
            }
        });

        //跳转activity3(weight属性详解-用match_parent,需要计算)
        btnTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,ThreeActivity.class);
                startActivity(i);
            }
        });

        //跳转activity4
        btnThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,FourActivity.class);
                startActivity(i);
            }
        });


        //跳转activity5
        btnFour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,FiveActivity.class);
                startActivity(i);
            }
        });

        //跳转activity6
        btnFive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,SixActivity.class);
                startActivity(i);
            }
        });

        //跳转activity7
        btnSix.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,SevenActivity.class);
                startActivity(i);
            }
        });

        //跳转activity8
        btnSeven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,EightActivity.class);
                startActivity(i);
            }
        });

        //跳转activity9
        btnEight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,NineActivity.class);
                startActivity(i);
            }
        });

        //跳转activity10
        btnNine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,TenActivity.class);
                startActivity(i);
            }
        });

        //跳转activity11
        btnTen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,ElevenActivity.class);
                startActivity(i);
            }
        });

        //跳转activity12
        btnEleven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this,TwelveActivity.class);
                startActivity(i);
            }
        });

    }
}
