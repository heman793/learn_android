package com.glen.intentdemo2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnOpenSite = null;
    private Button btnOpenDial = null;
    private Button btnOpenSMS = null;
    private Button btnOpenSMSTO = null;
    private Button btnInstall = null;
    private Button btnUnnstall = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenSite = (Button) findViewById(R.id.btnOpenSite);
        btnOpenDial = (Button) findViewById(R.id.btnOpenDial);
        btnOpenSMS = (Button) findViewById(R.id.btnOpenSMS);
        btnOpenSMSTO = (Button) findViewById(R.id.btnOpenSMSTO);
        btnInstall = (Button) findViewById(R.id.btnInstall);
        btnUnnstall = (Button) findViewById(R.id.btnUnnstall);


        btnOpenSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.cnblogs.com/puresoul"));
                startActivity(i);
            }
        });

        btnOpenDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:10086"));
                startActivity(i);
            }
        });

        btnOpenSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setType("vnd.android-dir/mms-sms");
                i.putExtra("sms_body","hello world");
                startActivity(i);
            }
        });

        btnOpenSMSTO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:18576770923"));
                intent.putExtra("sms_body", "堵车，晚点回家！"); //"sms_body"为固定内容
                startActivity(intent);
            }
        });
        btnInstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                Uri data = Uri.fromFile(new File("xxx/xx.apk"));
//                intent.setDataAndType(data, "application/vnd.android.package-archive");
//                startActivity(intent);
            }
        });

        btnUnnstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DELETE);
                Uri data = Uri.parse("package:com.glen.intentdemo");
                intent.setData(data);
                startActivity(intent);
            }
        });
    }
}
