package com.glen.innovationcourse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class TeacherDetailActivity extends AppCompatActivity {

    public static final String TAG = "TeacherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_detail);

        Log.e(TAG,"T onCreate");

        // 从Intent获取数据
        int imgId = getIntent().getIntExtra("teacher_image",0);
        String desc = getIntent().getStringExtra("teacher_desc");

        // 获取特定的视图
        ImageView imageView = (ImageView)findViewById(R.id.teacher_large_imageView);
        TextView textView = (TextView)findViewById(R.id.teacher_desc_textView);

        // 根据数据设置视图展现
        imageView.setImageResource(imgId);
        textView.setText(desc);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.e(TAG,"T onStart~~~");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG,"T onRestart~~~");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.e(TAG,"T onResume~~~");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.e(TAG,"T onPause~~~");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.e(TAG,"T onStop~~~");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e(TAG,"T onDestroy~~~");
    }
}
