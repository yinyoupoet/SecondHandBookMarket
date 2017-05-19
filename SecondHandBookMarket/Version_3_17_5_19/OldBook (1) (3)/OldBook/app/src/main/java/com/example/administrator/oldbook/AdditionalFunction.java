package com.example.administrator.oldbook;

public class AdditionalFunction {
	private String functionName;//������������
	
	private boolean switchState;
	
	public AdditionalFunction(String functionName, Boolean switchState)
	{
		this.functionName=functionName;
		this.switchState=switchState;
	}
	
	public String getFunctionName(){return functionName;}
	
	public boolean getSwitchState(){return switchState;}
	
}
