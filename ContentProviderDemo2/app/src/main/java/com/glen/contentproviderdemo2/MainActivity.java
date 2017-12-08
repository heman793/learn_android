package com.glen.contentproviderdemo2;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //操作 user 表
        this.user_operation();

        //操作 job 表
        this.job_operation();
    }

    //对user表进行操作
    private void user_operation()
    {
        //设置URI
        Uri uri_user = Uri.parse("content://com.glen.contentproviderdemo2.MyPrivoder/user");

        // 插入表中数据
        ContentValues values = new ContentValues();
        values.put("_id",3);
        values.put("name","Iverson");

        //获取ContentResolver
        ContentResolver resolver = getContentResolver();
        resolver.insert(uri_user,values);

        int count = 0;
        // 通过 ContentResolver 向 ContentProvider 中查询数据
        Cursor cursor  = resolver.query(uri_user,new String[]{"_id","name"},null,null,null);
        while (cursor.moveToNext())
        {
            count++;
            String result = "编号：" + cursor.getInt(0) +", 姓名：" + cursor.getString(1);
            System.out.println(result);// 将表中数据全部输出
        }

        System.out.println("查询记录共：" + count + " 条");
        cursor.close(); // 关闭游标
    }

    //对 job 表进行操作
    private void job_operation()
    {
        Uri uri_job = Uri.parse("content://com.glen.contentproviderdemo2.MyPrivoder/job");

        ContentValues values = new ContentValues();
        values.put("_id",3);
        values.put("job","Teacher");

        ContentResolver resolver = getContentResolver();
        resolver.insert(uri_job,values);

        Cursor cursor = resolver.query(uri_job,new String[]{"_id","job"},null,null,null);
        while (cursor.moveToNext())
        {
            String result = "编号：" + cursor.getInt(0) +", 职业：" + cursor.getString(1);
            System.out.println(result);
        }

        cursor.close();
    }

}
