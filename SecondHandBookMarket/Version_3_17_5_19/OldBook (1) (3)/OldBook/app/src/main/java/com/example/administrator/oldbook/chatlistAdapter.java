package com.example.administrator.oldbook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by hasee on 2017/5/13.
 */

public class chatlistAdapter extends ArrayAdapter<List_Info> {
    private int resourceId;

    public chatlistAdapter(Context context, int textViewResourceId, List<List_Info>objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        List_Info info = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.head = (ImageView) view.findViewById(R.id.chatList_Image);
            viewHolder.userName = (TextView) view.findViewById(R.id.chatList_username);
            viewHolder.date = (TextView) view.findViewById(R.id.chatList_date);
            viewHolder.content = (TextView) view.findViewById(R.id.chatList_content);

            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        //setImageResourxe()里面放的是int类型的
        viewHolder.head.setImageResource(info.head_photoId);
        viewHolder.head.setVisibility(View.VISIBLE);
        viewHolder.userName.setText(info.userName);
        viewHolder.userName.setVisibility(View.VISIBLE);

        //格式化时间
        //参考网址：https://zhidao.baidu.com/question/395446519.html
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.SIMPLIFIED_CHINESE);
        viewHolder.date.setText(sdf.format(info.time));
        viewHolder.date.setVisibility(View.VISIBLE);
        viewHolder.content.setText(info.content);
        viewHolder.content.setVisibility(View.VISIBLE);
        return view;
    }

    class ViewHolder{
        ImageView head;
        TextView userName;
        TextView date;
        TextView content;
    }
}
