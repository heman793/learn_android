package com.glen.uielementdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        //准备数据
        String[] names = {"Kobe","T-Mac","Jordan","Bird","Magic"};

        ArrayAdapter<String> array = new ArrayAdapter<String>
                (this,android.R.layout.simple_expandable_list_item_1,names);
        ListView list = (ListView) findViewById(R.id.list_test);
        list.setAdapter(array);

    }
}
