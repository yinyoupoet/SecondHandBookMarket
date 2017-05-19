package com.example.administrator.oldbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MyMessageActivity extends Fragment implements View.OnClickListener {

	private LinearLayout myMessage;
	private LinearLayout additionalFunctions;
	private LinearLayout orderManager;
	private RelativeLayout orderAllList;//���ж���
    private RelativeLayout orderWaitPay;//��֧��
    private RelativeLayout orderWaitSend;//������
    private RelativeLayout orderWaitGet;//���ջ�
    private RelativeLayout orderafterSell;//�˿��ۺ�
    private Intent intent;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.activity_my_message,container,false);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);//���ر�����
		//setContentView(R.layout.activity_my_message);
		orderManager = (LinearLayout)view.findViewById(R.id.order_manager);
		orderManager.setOnClickListener(this);
	    myMessage =(LinearLayout) view.findViewById(R.id.my_message);
	    myMessage.setOnClickListener(this);
	    additionalFunctions = (LinearLayout)view.findViewById(R.id.additional_functions);
	    additionalFunctions.setOnClickListener(this);
        orderWaitPay = (RelativeLayout) view.findViewById(R.id.order_wait_pay);
        orderWaitPay.setOnClickListener(this);
        orderWaitSend = (RelativeLayout) view.findViewById(R.id.order_wait_send);
        orderWaitSend.setOnClickListener(this);
        orderWaitGet = (RelativeLayout) view.findViewById(R.id.order_wait_get);
        orderWaitGet.setOnClickListener(this);
        orderAllList = (RelativeLayout) view.findViewById(R.id.order_assess);
	    orderAllList.setOnClickListener(this);
        orderafterSell = (RelativeLayout) view.findViewById(R.id.order_after_sell);
        orderafterSell.setOnClickListener(this);
		return view;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.my_picture:
			//��ͷ��Ŵ�
			break;
		case R.id.my_message:
			//�����ҵ���ϸ��Ϣҳ��
			intent = new Intent(getContext(),PersonMessageActivity.class);
			startActivity(intent);
			break;
		case R.id.additional_functions:
			intent = new Intent(getContext(),AdditionalFunctionActivity.class);
			startActivity(intent);
			break;
		case R.id.order_manager:
			intent = new Intent(getContext(),OrderManageActivity.class);
            intent.putExtra("page",1);
            startActivity(intent);
            break;
		case R.id.order_wait_pay:
			intent = new Intent(getContext(),OrderActivity.class);
            intent.putExtra("page",1);
            startActivity(intent);
            break;
		case R.id.order_wait_send:
			intent = new Intent(getContext(),OrderActivity.class);
            intent.putExtra("page",2);
            startActivity(intent);
            break;
		case R.id.order_wait_get:
			intent = new Intent(getContext(),OrderActivity.class);
            intent.putExtra("page",3);
            startActivity(intent);
            break;
		case R.id.order_assess:
			intent = new Intent(getContext(),OrderActivity.class);
            intent.putExtra("page",0);
            startActivity(intent);
            break;
		case R.id.order_after_sell:
			intent = new Intent(getContext(),OrderActivity.class);
            intent.putExtra("page",4);
            startActivity(intent);
			break;
			
		}
	}
}


