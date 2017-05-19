package com.example.administrator.oldbook;

import java.util.Date;

/**
 * Created by hasee on 2017/5/13.
 */

public class List_Info {
    public String userName;
    public String userId;
    public String content;
    public int head_photoId;
    public Date time;

    public List_Info(int head,String name,Date t_time,String c_content){
        head_photoId = head;
        userName = name;
        time = t_time;
        content = c_content;
    }
}
