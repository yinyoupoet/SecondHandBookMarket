package com.example.administrator.oldbook;

import java.util.List;

import com.example.administrator.oldbook.AdditionalFunctionAdapter.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderItemAdapter extends BaseAdapter{
	
	private List<OrderItem> orderList;
	private LayoutInflater inflater;
	public OrderItemAdapter(Context context, List<OrderItem> orderList) {
		// TODO Auto-generated constructor stub
		this.inflater=LayoutInflater.from(context);
		this.orderList=orderList;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return orderList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return orderList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		OrderItem orderItem =(OrderItem)getItem(position);
		ViewHolder viewHolder;
		if(convertView==null)
		{
			convertView = inflater.inflate(R.layout.listview_order_item, null);
			viewHolder=new ViewHolder();
			viewHolder.orderNo=(TextView)convertView.findViewById(R.id.order_no);
			viewHolder.bookImage=(ImageView)convertView.findViewById(R.id.book_image);
			viewHolder.orderState=(TextView)convertView.findViewById(R.id.order_state);
			convertView.setTag(viewHolder);
		} else {
			
			viewHolder = (ViewHolder)convertView.getTag();
		}
		viewHolder.orderNo.setText(orderItem.getOrderNo());
		viewHolder.bookImage.setImageResource(orderItem.getBook().getImageUrl());
		viewHolder.orderState.setText((orderItem.getOrderState())); 
		return convertView;
	}
	class ViewHolder{
		TextView orderNo;
		ImageView bookImage;
		TextView orderState;
	}

}
