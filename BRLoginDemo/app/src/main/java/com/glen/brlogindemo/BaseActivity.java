package com.glen.brlogindemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by heman on 17/12/4.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ActivityCollector.removeActivity(this);
    }
}
