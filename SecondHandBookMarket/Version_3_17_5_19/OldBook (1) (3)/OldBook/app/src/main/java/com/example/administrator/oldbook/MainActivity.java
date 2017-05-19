package com.example.administrator.oldbook;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements
        View.OnClickListener, RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener, View.OnTouchListener
{
    //region 字段声明
    private boolean isExit = false;       //判断是否退出的标志
    private RadioGroup bottomRadio;     //单选组声明
    private ImageButton talkImageButton;        //聊天按键声明
    private ImageButton locationImageButton;     //定位管键声明
    private EditText searchEdit;         //搜索框声明
    public String locatedInfo;     //定位位置信息声明
    public LocationClient mLocationClient;      //定位委托变量生命
    public static Toast mToast = null;       //Toast

    private int currentPage = 0;        //当前content页面
    private ViewPager contentViewPager;      //实现Tab滑动效果
    private ArrayList<Fragment> fragmentList;        //Fragment集合
    private FragmentManager fragmentManager;        //fragment管理器

    /*Create by 姚元帅*/
    private View mPanelView;
    private View mCloseButton;
    private View mPostButton;
    private View ScaleBookButton;
    //构造动画Animation的对象
    private Animation mButtonInAnimation;//按钮进入时的动画
    private Animation mButtonOutAnimation;//按钮退出时的动画
    private Animation mButtonScaleLargeAnimation;//按钮变大时的动画
    private Animation mButtonScaleSmallAnimation;//按钮变小时的动画
    private Animation mCloseRotateAnimation;//面板关闭
    private String IsPersion = "false";//判断是否允许权限
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

    //region 定义各个控件的对象，并设置他们的点击事件、属性等等
    public void Initialize()
    {
        searchEdit = (EditText) findViewById(R.id.main_search_exittext);         //搜索框定义
        bottomRadio = (RadioGroup) findViewById(R.id.main_bottom_radiogroup);        //单选组定义
        talkImageButton = (ImageButton) findViewById(R.id.main_bar_button_talk);      //聊天按钮定义
        locationImageButton = (ImageButton)findViewById(R.id.main_bar_button_location);     //定位按键定义
        contentViewPager = (ViewPager)findViewById(R.id.main_viewpager);        //内容页面定义
        fragmentList = new ArrayList<Fragment>();       //设置碎片集合
        fragmentList.add(new HomeFragment());       //添加碎片Home
        fragmentList.add(new DemandFragment());        //添加碎片Demand
        fragmentList.add(new OrderFragment());      //添加碎片Order
        fragmentList.add(new InformationFragment());        //添加碎片Information
        fragmentManager = getSupportFragmentManager();      //获取FragmentManager
        contentViewPager.setAdapter(new ContentFragmentPagerAdapter(fragmentManager,fragmentList));     //给ViewPager设置Adapter
        bottomRadio.setOnCheckedChangeListener(this);       //单选组的点击事件
        locationImageButton.setOnClickListener(this);       //定位按键点击事件
        talkImageButton.setOnClickListener(this);       //聊天按键点击事件
        searchEdit.setOnClickListener(this);        //搜索框点击事件
        contentViewPager.setOffscreenPageLimit(3);      //缓存三个页面
        contentViewPager.addOnPageChangeListener(this);     //滑动事件
        ((RadioButton)bottomRadio.findViewById(R.id.main_bt_home)).setChecked(true);        //默认home为第一页


        mLocationClient = new LocationClient(getApplicationContext());      //定义定位变量
        mLocationClient.registerLocationListener(new MyLocationListener());     //定位变量注册
        List<String> permissionList = new ArrayList<>();        //所需要的权限保存

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)       //申请位置权限
                != PackageManager.PERMISSION_GRANTED)
        {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }

        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.READ_PHONE_STATE)        //申请读取手机权限
                != PackageManager.PERMISSION_GRANTED)
        {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }

        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)      //申请外部文件写权限
                != PackageManager.PERMISSION_GRANTED)
        {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if(! permissionList.isEmpty())
        {
            String []permissions = permissionList.toArray(new String [permissionList.size()]);
            ActivityCompat.requestPermissions(MainActivity.this,permissions,2);
        }
        else
        {
            requestLocation();
        }

        /*Create by 姚元帅*/
        View addButton = findViewById(R.id.add);
        mPanelView = findViewById(R.id.panel);
        mCloseButton = findViewById(R.id.close);
        mPostButton = findViewById(R.id.post_demand);
        ScaleBookButton = findViewById(R.id.Scale_Book);

        addButton.setOnClickListener(this);
        mCloseButton.setOnClickListener(this);

        //为linearLayout整体构造手指接触函数
        mPostButton.setOnTouchListener(this);

        ScaleBookButton.setOnTouchListener(this);

        //初始化动画。
        initAnimation();
        //对从相册选择照片申请权限
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            IsPersion = "true";
        }
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
        if (!isExit)
        {
            isExit = true;
            showToast("再按一次退出程序");
            mHandler.sendEmptyMessageDelayed(0, 3000);      //延续三秒钟监听是否有再一次的返回
        }
        else
         {
            finish();
            System.exit(0);
        }
    }
    //endregion

    //region        按钮或控件点击事件
    public void onClickSearchExit()     //点击搜索框事件
    {
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);        //定义启动搜索页面intent
        startActivity(intent);       //启动搜索页面intent
    }

    public void onClickTalkButton()     //点击聊天按键事件
    {
        Intent intent = new Intent(MainActivity.this,chatListActivity.class);
        startActivity(intent);
       // showToast( "talk");
    }

    public void onClickLocationButton()     //点击定位按键事件
    {
        Intent intent = new Intent(getApplicationContext(), LocationActivity.class);        //定义启动搜索页面intent
        intent.putExtra("locat",locatedInfo);       //传递当前城市位置
        startActivity(intent);       //启动搜索页面intent
    }
    //endregion

    //region    定位初始化信息
    private void requestLocation()      //请求定位
    {
        LocationClientOption option = new LocationClientOption();       //声明定位的设置选项
        mLocationClient.setLocOption(option);       //设置定位选项
        option.setIsNeedAddress(true);      //使定位可以读取到详细的地名
        mLocationClient.start();        //定位开始
    }
    //endregion

    //region   按钮或控件的点击Switch选择事件
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.main_bar_button_talk:    //聊天点击事件
            {
                onClickTalkButton();
                break;
            }
            case R.id.main_bar_button_location:    //聊天点击事件
            {
                onClickLocationButton();
                break;
            }
            case R.id.main_search_exittext:    //搜索框按钮点击事件
            {
                onClickSearchExit();
                break;
            }
            case R.id.add:// 添加按钮
                openPanelView();
                break;
            case R.id.close:// 关闭按钮
                closePanelView();
                break;
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

    public void onCheckDemand()     //选中需求事件
    {
        showToast("Demand");
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
            case R.id.main_bt_demand :   //需求按钮点击事件
            {
                contentViewPager.setCurrentItem(1);
                onCheckDemand();
                break;
            }
            case R.id.main_bt_order :   //订单按钮点击事件
            {
                contentViewPager.setCurrentItem(2);
                onCheckOrder();
                break;
            }
            case R.id.main_bt_information :  //个人信息按钮点击事件
            {
                contentViewPager.setCurrentItem(3);
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
            case 0:     //home
            {
                if(position == 1)       //home to demand
                {
                    ((RadioButton)bottomRadio.findViewById(R.id.main_bt_demand)).setChecked(true);
                }
                 else if(position == 3)     //home to information
                {
                    ((RadioButton)bottomRadio.findViewById(R.id.main_bt_information)).setChecked(true);
                }
                break;
            }
            case 1:     //demand
            {
                if(position == 0)       //demand to home
                {
                   ((RadioButton)bottomRadio.findViewById(R.id.main_bt_home)).setChecked(true);
                }
                if(position == 2)       //demand to order
                {
                    ((RadioButton)bottomRadio.findViewById(R.id.main_bt_order)).setChecked(true);
                }
                break;
            }
            case 2:     //order
            {
                if(position == 1)       //order to demand
                {
                   ((RadioButton)bottomRadio.findViewById(R.id.main_bt_demand)).setChecked(true);
                }
                else if(position == 3)      //order to information
                {
                    ((RadioButton)bottomRadio.findViewById(R.id.main_bt_information)).setChecked(true);
                }
                break;
            }
            case 3:     //information
            {
                if(position == 0)       //information to home
                {
                    ((RadioButton)bottomRadio.findViewById(R.id.main_bt_home)).setChecked(true);
                }
                else if(position == 2)      //information to order
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
    /*Create by 姚元帅*/
    private void initAnimation() {
        //构造实例
        mButtonInAnimation = AnimationUtils.loadAnimation(this, R.anim.button_in);
        mButtonOutAnimation = AnimationUtils.loadAnimation(this, R.anim.button_out);
        mButtonScaleLargeAnimation = AnimationUtils.loadAnimation(this, R.anim.button_scale_to_large);
        mButtonScaleSmallAnimation = AnimationUtils.loadAnimation(this, R.anim.button_scale_to_small);
        mCloseRotateAnimation = AnimationUtils.loadAnimation(this, R.anim.close_rotate);


        mButtonOutAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    /*create by 姚元帅*/
    // 打开面板视图，打开面板视图时，启动按钮的进入动画，并为关闭按钮添加旋转动画。
    private void openPanelView() {
        //面板可见，RadioGroup隐藏
        bottomRadio.setVisibility(View.GONE);
        mPanelView.setVisibility(View.VISIBLE);
//        设置按钮进入面板
        mPostButton.startAnimation(mButtonInAnimation);
        ScaleBookButton.startAnimation(mButtonInAnimation);

//为关闭按钮添加旋转动画
        mCloseButton.startAnimation(mCloseRotateAnimation);
    }

    /*create by 姚元帅*/
    // 关闭面板视图
    private void closePanelView() {
        // 给按钮添加退出动画
        mPostButton.startAnimation(mButtonOutAnimation);
        ScaleBookButton.startAnimation(mButtonOutAnimation);
        // 按钮的退出动画执行完毕后，将面板隐藏,将RadioGroup设置为可见
        mPanelView.setVisibility(View.GONE);
        bottomRadio.setVisibility(View.VISIBLE);
    }

    /*create by 姚元帅*/
    @Override
    public void onBackPressed() {
        if (mPanelView.getVisibility() == View.VISIBLE) {
            closePanelView();

            return;
        }
        super.onBackPressed();
    }

    /*create by 姚元帅*/
    //    给按钮添加touch事件监听，根据用户操作执行放大和缩小的动画。
    @Override
    public boolean onTouch(final View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 手指按下，按钮执行放大动画
                v.startAnimation(mButtonScaleLargeAnimation);

                if (v == mPostButton) {
                    Intent PostIntent = new Intent(MainActivity.this, PostDemand.class);
                    startActivity(PostIntent);
                    break;
                }
                if (v == ScaleBookButton) {
                    Intent ScaleIntent = new Intent(MainActivity.this, SellingBooks.class);
                    ScaleIntent.putExtra("Ispersion", IsPersion);
                    startActivity(ScaleIntent);
                    break;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                // 手指移开，按钮执行缩小动画
                v.startAnimation(mButtonScaleSmallAnimation);
                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 缩小动画执行完毕后，将按钮的动画清除。这里的150毫秒是缩小动画的执行时间。
                        v.clearAnimation();
                    }
                }, 150);
                break;
        }
        return true;
    }

    /*create by 姚元帅*/
    //对申请做出回复
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {       //操作文件的权限申请
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    IsPersion = "true";
                } else {
                    showToast("拒绝该权限将无法上传照片");
                }
            }
            case 2:     //定位需求的权限申请
            {
                if(grantResults.length > 0)
                {
                    for(int result : grantResults)
                    {
                        if(result != PackageManager.PERMISSION_GRANTED)
                        {
                            showToast("必须同意所有权限才能使用本程序");
                            finish();
                            return;
                        }
                    }
                    requestLocation();
                }
                else
                {
                    showToast("发生未知错误");
                    finish();
                }
                break;
            }
            default:
                break;
        }
    }

    //region        定位自定义监听类
    public class MyLocationListener implements BDLocationListener       //自定义监听定位类
    {
        @Override
        public void onReceiveLocation(BDLocation location)
        {
            locatedInfo = location.getCity();       //得到定位的城市
            locatedInfo = locatedInfo.substring(0,locatedInfo.length() - 1);
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i)
        {

        }
    }
    //endregion
}
