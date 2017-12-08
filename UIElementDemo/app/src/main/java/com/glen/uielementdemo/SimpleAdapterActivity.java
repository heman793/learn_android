package com.glen.uielementdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterActivity extends AppCompatActivity {

    private String[] nickname = new String[]{"Kobe","T-Mac","AI"};
    private String[] says = new String[]{"To be No.1!","I have a dream!","Never Give up!"};
    private int[] imgIDs = new int[]{R.drawable.kobe,R.drawable.tmac,R.drawable.iverson};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);


        List<Map<String,Object>> listitem = new ArrayList<Map<String,Object>>();
        for (int i = 0; i <nickname.length; i++)
        {
            Map<String,Object> item = new HashMap<String, Object>();
            item.put("touxiang",imgIDs[i]);
            item.put("nickname",nickname[i]);
            item.put("says",says[i]);

            listitem.add(item);
        }

        SimpleAdapter sa = new SimpleAdapter(getApplicationContext(),listitem,
                R.layout.list_item,new String[]{"touxiang","nickname","says"},
                new int[]{R.id.imgTou,R.id.nickname,R.id.says});

        ListView listView =  (ListView) findViewById(R.id.list_test2);
        listView.setAdapter(sa);

    }
}
