package com.glen.eventdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

public class EventCallBackActivity extends AppCompatActivity {

    private static final String TAG = "EventCallBakc_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_call_back);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        Log.i(TAG, "我是EventCallBackActivity，发现触碰事件: " + event.getAction());
        Toast.makeText(EventCallBackActivity.this, "我是EventCallBackActivity，发现触碰事件！: "
                + event.getAction(), Toast.LENGTH_SHORT).show();
        return true;
    }
}
