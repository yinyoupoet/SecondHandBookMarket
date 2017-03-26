package com.example.administrator.oldbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class SignMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_layout);
        ActivityCollector.addActivity(this);
        ImageButton Sign_Image_Button = (ImageButton) findViewById(R.id.SignIn_Toolbar_Back);
        Sign_Image_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignMainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


}
