package com.example.administrator.oldbook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements
        View.OnClickListener, RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener
{
    //region 字段声明
    private boolean isExit = false;       //判断是否退出的标志
    private RadioGroup bottomRadio;     //单选组声明
    private ImageButton moreImageButton;        //更多按键声明
    private EditText searchEdit;         //搜索框声明
    private Toast mToast = null;       //Toast

    private int currentPage = 0;        //当前content页面
    private ViewPager contentViewPager;      //实现Tab滑动效果
    private ArrayList<Fragment> fragmentList;        //Fragment集合
    private FragmentManager fragmentManager;        //fragment管理器
    //endregion
    //region 按返回键激时发的handler
    private Handler mHandler = new Handler()        //退出处理器
    {
        @Override
        public void handleMessage(Message msg) {
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

        Initialize();
    }

    //region        Toast调用显示
    public void showToast(String info)
    {
        if(mToast != null)
        {
            mToast.setText(info);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        else
        {
            mToast = Toast.makeText(getApplicationContext(), info, Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
    //endregion

    //region 定义各个控件的对象，并设置他们的点击事件
    public void Initialize()
    {
        searchEdit = (EditText) findViewById(R.id.main_search_exittext);         //搜索框定义
        bottomRadio = (RadioGroup) findViewById(R.id.main_bottom_radiogroup);        //单选组定义
        moreImageButton = (ImageButton) findViewById(R.id.main_bar_button_more);      //更多按钮定义
        contentViewPager = (ViewPager)findViewById(R.id.main_viewpager);        //内容页面定义
        fragmentList = new ArrayList<Fragment>();       //设置碎片集合
        fragmentList.add(new HomeFragment());       //添加碎片Home
        fragmentList.add(new OrderFragment());      //添加碎片Order
        fragmentList.add(new InformationFragment());        //添加碎片Information
        fragmentManager = getSupportFragmentManager();      //获取FragmentManager
        contentViewPager.setAdapter(new ContentFragmentPagerAdapter(fragmentManager,fragmentList));     //给ViewPager设置Adapter
        bottomRadio.setOnCheckedChangeListener(this);
        moreImageButton.setOnClickListener(this);
        searchEdit.setOnClickListener(this);
        contentViewPager.setOffscreenPageLimit(2);      //缓存两个页面
        contentViewPager.addOnPageChangeListener(this);
        ((RadioButton)bottomRadio.findViewById(R.id.main_bt_home)).setChecked(true);
    }
    //endregion

    //region 返回键的点击事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)       //抓取按键信息
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)       //抓取back按键
        {
            exit();     //调用exit函数
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit()     //提示用户信息 是否退出校园书易
    {
        if (!isExit) {
            isExit = true;
            showToast("再按一次退出程序");
            mHandler.sendEmptyMessageDelayed(0, 3000);
        } else {
            finish();
            System.exit(0);
        }
    }
    //endregion

    //region        按钮或控件点击事件
    public void onClickSearchExit()     //点击搜索框事件
    {
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);
    }

    public void onClickMoreButton()     //点击更多按键事件
    {
        showToast( "more");
    }
    //endregion

    //region   按钮或控件的点击Switch选择事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_bar_button_more:    //更多按钮点击事件
            {
                onClickMoreButton();
                break;
            }
            case R.id.main_search_exittext:    //搜索框按钮点击事件
            {
                onClickSearchExit();
                break;
            }
            default:
                break;
        }
    }
    //endregion

    //region        RadioGroup Button单选事件
    public void onCheckHome()       //选中主页事件
    {
        showToast("Home");
    }

    public void onCheckOrder()      //选中订单事件
    {
        showToast("Order");
    }

    public void onCheckInformation()        //选中信息事件
    {
        showToast("Information");
    }
    //endregion

    //region  RadioGroup点击Switch选择事件
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId)
    {
        switch (checkedId)
        {
            case R.id.main_bt_home :    //主页按钮点击事件
            {
                contentViewPager.setCurrentItem(0);
                onCheckHome();
                break;
            }
            case R.id.main_bt_order :   //订单按钮点击事件
            {
                contentViewPager.setCurrentItem(1);
                onCheckOrder();
                break;
            }
            case R.id.main_bt_information :  //个人信息按钮点击事件
            {
                contentViewPager.setCurrentItem(2);
                onCheckInformation();
                break;
            }
        default:
            break;
        }
    }
    //endregion

    //region        滑动界面事件
    @Override
    public void onPageSelected(int position)
    {
        switch(currentPage)
        {
            case 0:
            {
                if(position == 1)
                {
                    ((RadioButton)bottomRadio.findViewById(R.id.main_bt_order)).setChecked(true);
                }
                 else if(position == 2)
                {
                    ((RadioButton)bottomRadio.findViewById(R.id.main_bt_information)).setChecked(true);
                }
                break;
            }
            case 1:
            {
                if(position == 0)
                {
                   ((RadioButton)bottomRadio.findViewById(R.id.main_bt_home)).setChecked(true);
                }
                if(position == 2)
                {
                    ((RadioButton)bottomRadio.findViewById(R.id.main_bt_information)).setChecked(true);
                }
                break;
            }
            case 2:
            {
                if(position == 0)
                {
                   ((RadioButton)bottomRadio.findViewById(R.id.main_bt_home)).setChecked(true);
                }
                else if(position == 1)
                {
                    ((RadioButton)bottomRadio.findViewById(R.id.main_bt_order)).setChecked(true);
                }
                break;
            }
            default:
                break;
        }
        currentPage = position;
    }
    //endregion

    //region    没用到的方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {   }

    @Override
    public void onPageScrollStateChanged(int state)
    {   }
    //endregion

}
