package com.example.administrator.oldbook;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class OrderManageActivity extends SwipeBackActivity{
//	private ListView listView;
//	private List<OrderItem> orderList = new ArrayList<OrderItem>();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_manage);
//		initOrderList();
//		OrderItemAdapter adapter = new OrderItemAdapter(OrderManageActivity.this, orderList);
//		listView = (ListView)findViewById(R.id.order_listview);
//		listView.setAdapter(adapter);
	}
//	private void initOrderList() {
//		// TODO Auto-generated method stub
//		Book book1 = new Book(R.drawable.demo,"������̵���","IT��",48.99,24,1);
//		Book book2 = new Book(R.drawable.demo,"���ֵ��Ӽ�������","IT��",58.99,28,2);
//		Book book3 = new Book(R.drawable.demo,"���������","IT��",59.8,40,1);
//		OrderItem orderitem1 = new OrderItem("XYSY234560987233","������", 24, book1);
//		OrderItem orderitem2 = new OrderItem("XYSY783012384579", "���ջ�", 28, book2);
//		OrderItem orderitem3 = new OrderItem("XYSY235784536233", "��ǩ��", 24, book3);
//		orderList.add(orderitem1);
//		orderList.add(orderitem2);
//		orderList.add(orderitem3);
//	}
}
