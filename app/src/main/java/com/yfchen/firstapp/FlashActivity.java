package com.yfchen.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class FlashActivity extends Activity {

    android.os.Handler sHandler = new Handler();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);//关联布局页面

        Toast.makeText(FlashActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
        //打开界面延迟切换

        findViewById(R.id.textView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击按钮事件
                Intent intent = new Intent(FlashActivity.this,MainActivity.class);
                startActivities(new Intent[]{intent});
                finish();
            }
        });

        sHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(FlashActivity.this,MainActivity.class);
                startActivities(new Intent[]{intent});
                finish();

            }
        }, 1000);


    }


}
