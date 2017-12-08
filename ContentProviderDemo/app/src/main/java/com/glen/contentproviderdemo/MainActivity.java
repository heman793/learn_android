package com.glen.contentproviderdemo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ContentResolver contentResolver;
    Uri uri = Uri.parse("content://com.glen.contentproviderdemo.FirstProvider");

    private Button btnQuery = null;
    private Button btnInsert = null;
    private Button btnUpdate = null;
    private Button btnDelete = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取系统 ContentResolver 对象
        contentResolver = getContentResolver();

        btnQuery = (Button) findViewById(R.id.btnQuery);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用content
                Cursor c = contentResolver.query(uri,null,"query_where",null,null);
                Toast.makeText(MainActivity.this,"cursor返回值为：" + c,Toast.LENGTH_SHORT).show();
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("name","jordan");
                Uri newUri = contentResolver.insert(uri,values);
                Toast.makeText(MainActivity.this,"新插入记录的Uri为："+newUri,
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("name","kobe");
                int count = contentResolver.update(uri,values,"update_where",null);
                Toast.makeText(MainActivity.this,"更新记录为:"+count,Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = contentResolver.delete(uri,"delete_where",null);
                Toast.makeText(MainActivity.this,"删除记录数据为：" + count,Toast.LENGTH_SHORT).show();
            }
        });

    }

}
