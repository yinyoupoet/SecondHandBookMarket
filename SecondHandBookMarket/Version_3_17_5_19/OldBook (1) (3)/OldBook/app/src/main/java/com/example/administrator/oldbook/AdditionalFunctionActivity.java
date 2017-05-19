package com.example.administrator.oldbook;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;

public class AdditionalFunctionActivity extends Activity{
	
	private ListView listView;
	private List<AdditionalFunction> functionList = new ArrayList<AdditionalFunction>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_additional_function);
		initAdditionalFunctions();
		AdditionalFunctionAdapter adapter = new AdditionalFunctionAdapter(AdditionalFunctionActivity.this, functionList);
		listView=(ListView)findViewById(R.id.list_additional_function);
		listView.setAdapter(adapter);
		Toast.makeText(this, "111111111111", Toast.LENGTH_SHORT).show();
	}
	private void initAdditionalFunctions() {
		AdditionalFunction nightMode = new AdditionalFunction("夜间模式",false);
		AdditionalFunction messagePush = new AdditionalFunction("消息推送",false);
		AdditionalFunction restMode = new AdditionalFunction("勿扰模式",true);
		AdditionalFunction autoUpdate = new AdditionalFunction("自动升级",true);
		AdditionalFunction shakeScreen = new AdditionalFunction("收到消息时震动",true);
		functionList.add(messagePush);
		functionList.add(nightMode);
		functionList.add(restMode);
		functionList.add(shakeScreen);
		functionList.add(autoUpdate);
	}
}
