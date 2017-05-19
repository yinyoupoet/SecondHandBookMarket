package com.example.administrator.oldbook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hasee on 2017/5/13.
 * @author ZK
 * 这是聊天列表界面
 */


public class chatListActivity extends AppCompatActivity{
    private ListView chatlistView;
    private chatlistAdapter adapter;
    private final static List<List_Info>  chatList= initList();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatlist_layout);
        //toolbar  http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2014/1118/2006.html
        Toolbar chatlist_toolbar = (Toolbar) findViewById(R.id.chatlist_toolbar);
        //给toolbar上设置控件
        chatlist_toolbar.setTitle("消息");
        setSupportActionBar(chatlist_toolbar);
        chatlist_toolbar.setNavigationIcon(R.drawable.chatlist_return);
        chatlist_toolbar.setOnMenuItemClickListener(onMenuItemClickListener);

        chatlist_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //initList();
        chatList.get(0).content = ChatActivity.msgList.get(ChatActivity.msgList.size()-1).getContent();


        adapter = new chatlistAdapter(this,R.layout.chatlist_item_layout,chatList);
        chatlistView = (ListView) findViewById(R.id.chatList);
        chatlistView.setAdapter(adapter);
        chatlistView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List_Info info = chatList.get(position);
                Intent intent = new Intent(getApplicationContext(),ChatActivity.class);
               startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        chatList.get(0).content = ChatActivity.msgList.get(ChatActivity.msgList.size()-1).getContent();
        adapter.notifyDataSetChanged();
        super.onResume();
    }

    @Override
    protected void onPause() {
        chatList.get(0).content = ChatActivity.msgList.get(ChatActivity.msgList.size()-1).getContent();
        super.onPause();
    }

    private static List<List_Info> initList(){
        List<List_Info>  chatList= new ArrayList<List_Info>();
        String text = ChatActivity.msgList.get(ChatActivity.msgList.size()-1).getContent();
        List_Info info1 = new List_Info(R.drawable.head3,"一路向北",new Date(),text);
        chatList.add(info1);
        List_Info info2 = new List_Info(R.drawable.head2,"欧我的熊宝贝",new Date(),"这本书很值钱的呦!");
        chatList.add(info2);
        return chatList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chatlist,menu);
        return true;
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            String msg = "";
            switch (item.getItemId()){
                case R.id.chat_beginChat:

                    break;
            }
            return true;
        }
    };

}
