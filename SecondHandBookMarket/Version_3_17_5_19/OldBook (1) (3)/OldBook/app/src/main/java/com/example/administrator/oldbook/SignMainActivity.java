package com.example.administrator.oldbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class SignMainActivity extends SwipeBackActivity {
    private SwipeBackLayout swipeBackLayout;        // 定义SwipebackLayout变量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_layout);





        Toolbar register_toolbar = (Toolbar) findViewById(R.id.register_toolbar);
        register_toolbar.setTitle("注册");
        //setSupportActionBar(register_toolbar);
        register_toolbar.setNavigationIcon(R.drawable.chatlist_return);
        register_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




        ActivityCollector.addActivity(this);
       Button Sign_Image_Button = (Button) findViewById(R.id.btn_rg);
        Sign_Image_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignMainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


}
