package com.example.administrator.oldbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Timer;
import java.util.TimerTask;

public class AdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_layout);
        ImageView photo = (ImageView) findViewById(R.id.first_photo);

        Glide.with(AdActivity.this).load(R.drawable.firstpage_image).into(photo);


        ActivityCollector.addActivity(this);
        final Intent intent = new Intent(AdActivity.this, LoginActivity.class);
        //2秒后自动打开另一界面
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {      //定义线程任务
            @Override
            public void run() {
                startActivity(intent); //执行
                Timer timer = new Timer();      //定义定时器
                TimerTask task = new TimerTask()        //定义关闭启动界面线程任务
                {
                    @Override
                    public void run()
                    {
                        finish();       //关闭启动界面
                    }
                };
                timer.schedule(task,2000);
            }
        };
        timer.schedule(task, 1000 * 2); //2秒后
    }
}
