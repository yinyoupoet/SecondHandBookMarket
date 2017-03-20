package com.example.administrator.oldbook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    //region 字段定义
    private boolean isExit=false;       //判断是否退出的标志
    //endregion

    //region 按返回键激时发的handler
    private Handler mHandler = new Handler()        //exit handler
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        getSupportActionBar().hide();

        //region 获取各个按钮的对象，并设置他们的点击事件
        Button homeButton = (Button)findViewById(R.id.main_bt_home);        //主页按钮
        Button orderButton = (Button)findViewById(R.id.main_bt_order);      //订单按钮
        Button infomationButton = (Button)findViewById(R.id.main_bt_infomation);        //个人信息按钮
        ImageButton moreButton = (ImageButton)findViewById(R.id.main_bar_button_more);      //更多 按钮
        EditText editText = (EditText) findViewById(R.id.Main_Search_EditText);         //搜索框
        homeButton.setOnClickListener(this);
        orderButton.setOnClickListener(this);
        infomationButton.setOnClickListener(this);
        moreButton.setOnClickListener(this);
        editText.setOnClickListener(this);
        //endregion

    }

    //region 返回键的点击事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)       //catch click back key
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit()     //sure to exit the application
    {
        if (!isExit)
        {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(0, 3000);
        }
        else
        {
            finish();
            System.exit(0);
        }
    }

    //endregion

    //region   按钮或控件的点击事件
    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.main_bt_home :    //主页按钮点击事件
            {

                break;
            }
            case R.id.main_bt_order :   //订单按钮点击事件
            {

            }
            case R.id.main_bt_infomation :  //个人信息按钮点击事件
            {

                break;
            }
            case R.id.main_bar_button_more :    //更多按钮点击事件
            {

                break;
            }
            case R.id.Main_Search_EditText :    //搜索框按钮点击事件
            {
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
                break;
            }
            default:
                break;
        }
    }
    //endregion

}
