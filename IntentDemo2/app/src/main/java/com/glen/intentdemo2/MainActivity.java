package com.glen.intentdemo2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnFirst = null;
    private Button btnSecond = null;
    private Button btnThird = null;
    final int PICK_CONTACT = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFirst = (Button)findViewById(R.id.btnFirst);
        btnSecond = (Button)findViewById(R.id.btnSecond);
        btnThird = (Button)findViewById(R.id.btnThird);

        //启动第一个Activity,指定组件名称---显式Intent
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //方法一：创建一个意图对象
                Intent i = new Intent();
                //创建组件，通过组件来响应
                ComponentName cn = new ComponentName(MainActivity.this,FirstActivity.class);
                i.setComponent(cn);
                startActivity(i);

                //方法二：
//                Intent i = new Intent();
//                i.setClass(MainActivity.this,FirstActivity.class);
//                startActivity(i);

                //方法三：
//                Intent i = new Intent(MainActivity.this,FirstActivity.class);
//                startActivity(i);

            }
        });

        //启动一个Activity,通过action属性进行查找--隐式Intent
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //方法一：
                Intent i  = new Intent();
                //设置action属性，属性值就是一个普通字条串
                i.setAction("com.glen.intent.action.MY_ACTION");
                //设置Category属性
                i.addCategory("com.glen.intent.category.MY_CATEGORY");
                startActivity(i);

                //方法二：
//                Intent i = new Intent("com.glen.intent.action.MY_ACTION");
//                startActivity(i);
            }
        });

        //查看联系人
        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("vnd.android.cursor.item/phone");
                startActivityForResult(intent,PICK_CONTACT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case (PICK_CONTACT):
                if (resultCode == Activity.RESULT_OK)
                {
                //获取返回的数据
                Uri contactData = data.getData();
                CursorLoader cursorLoader = new CursorLoader(this,contactData,null,null,null,null);

                //查询联系人信息
                Cursor cursor = cursorLoader.loadInBackground();
                //如果查询到指定的联系人
                if(cursor.moveToNext())
                {
                    String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                    String phoneNum = "此联系人暂未电话号码";

                    Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId,null,null);

                    if (phones.moveToFirst())
                    {
                        phoneNum = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    }

                    phones.close(); //关闭游标

                    //显示联系人名称、电话号
                    EditText name_show = (EditText) findViewById(R.id.name_show);
                    EditText phone_show = (EditText) findViewById(R.id.phone_show);
                    name_show.setText(name);
                    phone_show.setText(phoneNum);

                }

                cursor.close();//关闭游标
            }

            break;

        }


    }
}
