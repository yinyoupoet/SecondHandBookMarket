package com.example.administrator.oldbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class AdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_layout);
        ActivityCollector.addActivity(this);
        final Intent intent = new Intent(AdActivity.this, LoginActivity.class);
        //2秒后自动打开另一界面
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(intent); //执行
                finish();
            }
        };
        timer.schedule(task, 1000 * 2); //2秒后
    }
}
