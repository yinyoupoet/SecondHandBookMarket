package com.example.administrator.oldbook;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2017/5/9.
 */

public class ChatActivity extends AppCompatActivity{
    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private chatMsgAdapter adapter;

    public final static List<chat_Msg> msgList = initMsgs();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_layout);

        Toolbar chat_toolbar = (Toolbar) findViewById(R.id.chat_toolbar);
        chat_toolbar.setTitle("一路向北");

        setSupportActionBar(chat_toolbar);
        chat_toolbar.setNavigationIcon(R.drawable.chatlist_return);

        chat_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //initMsgs();
        adapter = new chatMsgAdapter(this, R.layout.msg_item_layout,msgList);
        inputText = (EditText) findViewById(R.id.input_msg);
        send = (Button) findViewById(R.id.send_msg);
        msgListView = (ListView) findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    chat_Msg msg = new chat_Msg(content, chat_Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");
                }
            }
        });
    }

    private static List<chat_Msg> initMsgs(){
        List<chat_Msg> msgList_ = new ArrayList<chat_Msg>();
        chat_Msg msg1 = new chat_Msg("Hey guy,how's it going?", chat_Msg.TYPE_RECEIVED);
        msgList_.add(msg1);
        chat_Msg msg2 = new chat_Msg("Not bad,how about you?", chat_Msg.TYPE_SEND);
        msgList_.add(msg2);
        chat_Msg msg3 = new chat_Msg("I am fine,thanks.", chat_Msg.TYPE_RECEIVED);
        msgList_.add(msg3);
        return msgList_;
    }


}
