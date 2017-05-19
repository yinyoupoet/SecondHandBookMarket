package com.example.administrator.oldbook;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdditionalFunctionAdapter extends BaseAdapter{
	
	
	private LayoutInflater inflater;
	private List<AdditionalFunction> functionList;
	public AdditionalFunctionAdapter(Context context, List<AdditionalFunction> functionList) {
		this.inflater=LayoutInflater.from(context);
		this.functionList=functionList;
		
	}
	
	

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		AdditionalFunction additionalFunction =(AdditionalFunction)this.getItem(position);
		ViewHolder viewHolder;
		if(convertView==null)
		{
			convertView = inflater.inflate(R.layout.list_additional_function_item, null);
			viewHolder=new ViewHolder();
			viewHolder.functionName=(TextView)convertView.findViewById(R.id.function_name);
			viewHolder.switchState=(SwitchButton)convertView.findViewById(R.id.switch_state);
			convertView.setTag(viewHolder);
		} else {
			
			viewHolder = (ViewHolder)convertView.getTag();
		}
		viewHolder.functionName.setText(additionalFunction.getFunctionName());
		viewHolder.switchState.setCheck(additionalFunction.getSwitchState());
		return convertView;
	}
	class ViewHolder{
		TextView functionName;
		SwitchButton switchState;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return functionList.size();
	}



	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return functionList.get(position);
	}



	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
}
