package com.example.administrator.oldbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class FourButtonFragment extends Fragment implements View.OnClickListener
{
    private LinearLayout ArtsLinear;           //文科
    private LinearLayout EngineeringLinear;     //工科
    private LinearLayout ScienceLinear;     //理科
    private LinearLayout OtherLinear;       //其它

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //region      定义变量
        View view = inflater.inflate(R.layout.four_button_layout,container,false);
        EngineeringLinear = (LinearLayout)view.findViewById(R.id.Engineering);
        ScienceLinear = (LinearLayout)view.findViewById(R.id.Science);
        ArtsLinear = (LinearLayout)view.findViewById(R.id.Arts);
        OtherLinear = (LinearLayout)view.findViewById(R.id.Other);
        //endregion

        //region      四个分类的点击事件
        ArtsLinear.setOnClickListener(this);
        EngineeringLinear.setOnClickListener(this);
        ScienceLinear.setOnClickListener(this);
        OtherLinear.setOnClickListener(this);
        //endregion

        return view;
    }

    //region        点击事件
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.Engineering:
            {
                onClickClassify("Engineering");
                break;
            }
            case R.id.Science:
            {
                onClickClassify("Science");
                break;
            }
            case R.id.Arts:
            {
                onClickClassify("Arts");
                break;
            }
            case R.id.Other:
            {
                onClickClassify("Other");
                break;
            }
            default:
                break;
        }
    }
    //endregion

    private void onClickClassify(String subject)
    {
        Intent intent = new Intent(getContext(),ClassifyActivity.class);        //intent 声明
        intent.putExtra("classify",subject);        //传递信息区分四个分类
        startActivity(intent);      //启动下一个活动
    }

}
