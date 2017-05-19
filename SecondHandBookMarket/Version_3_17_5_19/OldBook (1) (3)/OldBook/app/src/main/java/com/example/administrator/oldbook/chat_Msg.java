package com.example.administrator.oldbook;

/**
 * Created by hasee on 2017/5/9.
 */

public class chat_Msg {
    public static final int TYPE_RECEIVED = 0;  //接收信息
    public static final int TYPE_SEND = 1;      //发送信息

    private String content;
    private int type;

    public chat_Msg(String content, int type){
        this.content = content;
        this.type = type;
    }
    public String getContent(){
        return content;
    }
    public int getType(){
        return type;
    }
}
