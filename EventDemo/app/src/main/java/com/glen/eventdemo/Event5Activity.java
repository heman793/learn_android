package com.glen.eventdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


/**直接绑定到标签
 *    1、直接在xml布局文件中对应得Activity中定义一个事件处理方法 eg:public void myClick(View source)
 *          --source 对应事件源(组件)
 *    2、接着在布局文件中对应要触发事件的组件,设置一个属性:onclick = "myclick"即可
 */
public class Event5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event5);
    }

    //自定义一个方法,传入一个view组件作为参数
    public void myClick(View v)
    {
        Toast.makeText(getApplicationContext(), "点击<绑定到标签>按钮", Toast.LENGTH_SHORT).show();
    }
}
