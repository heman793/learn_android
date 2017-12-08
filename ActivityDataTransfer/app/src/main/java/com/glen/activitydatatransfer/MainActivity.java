package com.glen.activitydatatransfer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private Button btnRegister = null;
    private EditText editName = null;
    private RadioGroup rad = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister = (Button) findViewById(R.id.btnregister);
        editName = (EditText) findViewById(R.id.editname);
        rad = (RadioGroup) findViewById(R.id.radioGroup);

        btnRegister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                String name,sex = "";
                Intent it = new Intent(MainActivity.this,SuccessActivity.class);

                name = editName.getText().toString();

                //遍历RadioGroup找出被选中的单选按钮
                for (int i = 0; i < rad.getChildCount(); i++){
                    RadioButton rb = (RadioButton) rad.getChildAt(i);
                    if (rb.isChecked())
                    {
                        sex = rb.getText().toString();
                        break;
                    }
                }

                //新建Bundle对象,并把数据写入
                Bundle b = new Bundle();
                b.putCharSequence("user",name);
                b.putCharSequence("sex",sex);

                //将数据包Bundle绑定到Intent上
                it.putExtras(b);
                startActivity(it);

                //关闭第一个Activity
                finish();
            }

        });

    }


}
