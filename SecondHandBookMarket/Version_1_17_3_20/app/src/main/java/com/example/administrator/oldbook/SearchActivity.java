package com.example.administrator.oldbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;

public class SearchActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.search_layout);

        ImageButton Back_Button = (ImageButton) findViewById(R.id.Search_Back_Button);      // Bar返回键按钮
        Back_Button.setOnClickListener(new View.OnClickListener()       //Bar返回按键
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
