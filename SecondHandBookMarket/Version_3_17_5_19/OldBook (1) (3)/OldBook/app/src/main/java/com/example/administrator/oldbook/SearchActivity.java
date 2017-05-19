package com.example.administrator.oldbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;

import android.widget.ImageButton;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class SearchActivity extends SwipeBackActivity implements View.OnClickListener
{
    private SwipeBackLayout swipeBackLayout;        // 定义SwipebackLayout变量

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);

        swipeBackLayout = getSwipeBackLayout();     //得到SwipeBackLayout对象
        DisplayMetrics displayMetrics = new DisplayMetrics();       //定义将要获得手机宽度的DisplayMetrics

        swipeBackLayout.setEnableGesture(true);
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int phoneWidth = displayMetrics.widthPixels;
        swipeBackLayout.setEdgeSize(phoneWidth / 2);

        Toolbar searchToolbar = (Toolbar)findViewById(R.id.search_toolbar);         //得到toolbar对象
        ImageButton backImageButton = (ImageButton) findViewById(R.id.search_back_imagebutton);     // 返回按键
        ImageButton searchImageButton = (ImageButton)findViewById(R.id.search_imagebutton);     // 搜索按键
        searchToolbar.setOnClickListener(this);
        backImageButton.setOnClickListener(this);
        searchImageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)     //点击事件
    {
        switch(v.getId())
        {
            case R.id.search_back_imagebutton:      //返回按键事件
            {/*
                Intent intent = new Intent(SearchActivity.this,MainActivity.class);
                startActivity(intent);*/

                scrollToFinishActivity();
                break;
            }
            case R.id.search_imagebutton :      //搜索按键事件
            {

                break;
            }
            case R.id.search_toolbar:
            {
                scrollToFinishActivity();
                break;
            }
            default :
                break;
        }
    }
}
