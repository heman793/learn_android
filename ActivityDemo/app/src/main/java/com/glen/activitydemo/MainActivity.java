package com.glen.activitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "ActivityDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG,"start onCreate");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.e(TAG,"start onStart~~~");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG,"start onRestart~~~");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.e(TAG,"start onResume~~~");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.e(TAG,"start onPause~~~");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.e(TAG,"start onStop~~~");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e(TAG,"start onDestroy~~~");
    }

}
