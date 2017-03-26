package com.example.administrator.oldbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);

        ImageButton backImageButton = (ImageButton) findViewById(R.id.search_back_imagebutton);     // 返回按键
        ImageButton searchImageButton = (ImageButton)findViewById(R.id.search_imagebutton);     // 搜索按键
        backImageButton.setOnClickListener(this);
        searchImageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)     //点击事件
    {
        switch(v.getId())
        {
            case R.id.search_back_imagebutton:      //返回按键事件
            {
                Intent intent = new Intent(SearchActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.search_imagebutton :      //搜索按键事件
            {

                break;
            }
            default :
                break;
        }
    }
}
