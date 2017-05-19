package com.example.administrator.oldbook;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class FluentPhotoFragment extends Fragment
{

    private ViewPager viewPager;        //滚动图片组
    private LinearLayout dotLayout;     //滚动圆点布局
    private ArrayList<ImageView> imageList;

    private boolean isRunning = true;
    private int lastPosition = 0;

    private final int[] images = { R.drawable.fluent_photo_001, R.drawable.fluent_photo_002, R.drawable.fluent_photo_003, R.drawable.fluent_photo_004};

    private Handler handler = new Handler()
    {
        public void handleMessage(android.os.Message msg)
        {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            if (isRunning) {
                handler.sendEmptyMessageDelayed(0, 2000);
            }

        };
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fluent_photo_layout,container,false);
        viewPager = (ViewPager)view.findViewById(R.id.main_viewpager);
        dotLayout = (LinearLayout)view.findViewById(R.id.main_fluent_dot);
        imageList = new ArrayList<ImageView>();


        // 初始化图片资源
        for (int image : images)
        {
            // 初始化图片资源
            ImageView imageView = new ImageView(getContext());
            imageView.setBackgroundResource(image);
            imageList.add(imageView);

            // 添加指示小点
            ImageView dot = new ImageView(getContext());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(32,32);      //滚动圆点大小
            dot.setLayoutParams(params);
            dot.setBackgroundResource(R.drawable.fluent_photo_dot_normal);

            if (image == R.drawable.fluent_photo_001)       //默认第一个为选中圆点
            {
                dot.setBackgroundResource(R.drawable.fluent_photo_dot_selected);
            }

            dotLayout.addView(dot);
        }

        viewPager.setAdapter(new MyPageAdapter());
        viewPager.setCurrentItem(Integer.MAX_VALUE / 2 - (Integer.MAX_VALUE / 2 % imageList.size()));       // 设置当前viewPager的位置
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {

            @Override
            public void onPageSelected(int position)
            {
                // 页面切换后调用， position是新的页面位置

                // 实现无限制循环播放
                position %= imageList.size();

                // 把当前点设置为true,将上一个点设为false
                dotLayout.getChildAt(position).setBackgroundResource(R.drawable.fluent_photo_dot_selected);
                dotLayout.getChildAt(lastPosition).setBackgroundResource(R.drawable.fluent_photo_dot_normal);
                lastPosition = position;
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {
                // 页面正在滑动时间回调
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {
                // 当pageView 状态发生改变的时候，回调
            }
        });

        handler.sendEmptyMessageDelayed(0, 2000);
        return view;
    }

    @Override
    public void onDestroy()
    {
        isRunning = false;
        super.onDestroy();
    }

    private class MyPageAdapter extends PagerAdapter
    {
        @Override
        public int getCount()
        {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object)
        {
            if (view == object)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            container.addView(imageList.get(position % imageList.size()));
            return imageList.get(position % imageList.size());
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
        {
            container.removeView((View) object);
            object = null;
        }
    }
}
