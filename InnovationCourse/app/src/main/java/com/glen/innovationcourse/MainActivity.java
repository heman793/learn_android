package com.glen.innovationcourse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG,"M onCreate");

//        ArrayAdapter<String> teacherAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1,Teacher.getAllTeachers());

        TeacherAdapter ta = new TeacherAdapter(this,R.layout.teacher_item,Teacher.getAllTeachers());

        ListView listView = (ListView)findViewById(R.id.teacher_listView);

        listView.setAdapter(ta);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.e(TAG,"M onStart~~~");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG,"M onRestart~~~");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.e(TAG,"M onResume~~~");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.e(TAG,"M onPause~~~");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.e(TAG,"M onStop~~~");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e(TAG,"M onDestroy~~~");
    }
}
