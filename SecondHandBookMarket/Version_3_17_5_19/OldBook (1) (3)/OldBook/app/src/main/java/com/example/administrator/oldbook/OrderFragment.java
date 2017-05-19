package com.example.administrator.oldbook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment
{
    public ListView listView;
    private List<OrderItem> orderList = new ArrayList<OrderItem>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.order_fragment_layout,container,false);

        initOrderList();
        OrderItemAdapter adapter = new OrderItemAdapter(getContext(), orderList);
        listView = (ListView)view.findViewById(R.id.order_listview);
        listView.setAdapter(adapter);

        if(getParentFragment() != null )
        {
            if( getParentFragment().getClass().equals(HomeFragment.class))
            {
                listView.setFocusable(false);
                setListViewHeightBasedOnChildren(listView);
            }
        }

        return view;
    }

    private void initOrderList() {
        // TODO Auto-generated method stub
        Book book1 = new Book(R.drawable.demo,"软件工程","IT类",48.99,24,1);
        Book book2 = new Book(R.drawable.demo,"计算机网络","IT类",58.99,28,2);
        Book book3 = new Book(R.drawable.demo,"数据库系统概论","IT类",59.8,40,1);
        OrderItem orderitem1 = new OrderItem("XYSY234560987233","已发货", 24, book1);
        OrderItem orderitem2 = new OrderItem("XYSY783012384579", "未发货", 28, book2);
        OrderItem orderitem3 = new OrderItem("XYSY235784536233", "已签收", 24, book3);
        orderList.add(orderitem1);
        orderList.add(orderitem2);
        orderList.add(orderitem3);
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0); // 计算子项View 的宽高
            totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }
}
