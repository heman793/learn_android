package com.glen.activitydatatransfer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class SuccessActivity extends ActionBarActivity {

    private TextView txtshow = null;
    private String name = null;
    private String sex = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        txtshow = (TextView) findViewById(R.id.txtshow);

        Intent it = getIntent();
        Bundle b = it.getExtras();

        name = b.getCharSequence("user").toString();
        sex = b.getCharSequence("sex").toString();

        txtshow.setText("尊敬的："+ name + " " + sex + "士" + "，恭喜你，注册成功！");
    }
}
