package com.example.administrator.oldbook;
/*create by 姚元帅*/
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class PostDemand extends SwipeBackActivity implements View.OnClickListener {

    private Button PostButton;
    private Button CancleButton;
    private EditText Nedittext;
    private EditText Bedittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_demand);
        PostButton = (Button) findViewById(R.id.publish);
        CancleButton = (Button) findViewById(R.id.cancle);
        Nedittext = (EditText) findViewById(R.id.Content_Editext);
        Bedittext = (EditText) findViewById(R.id.Demend_Editext);
        PostButton.setOnClickListener(this);
        CancleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.publish:// 添加按钮
                if ((Bedittext.getText().toString().length() == 0)) {
                    Toast.makeText(this, "标题不能为空", Toast.LENGTH_LONG).show();
                    break;
                } else if ((Nedittext.getText().toString().length() == 0)) {
                    Toast.makeText(this, "内容不能为空", Toast.LENGTH_LONG).show();
                    break;
                } else {
                    Toast.makeText(this, "发布需求成功", Toast.LENGTH_LONG).show();
                    break;
                }
            case R.id.cancle:// 关闭按钮
                Toast.makeText(this, "取消发布", Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)       //抓取按键信息
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)       //抓取back按键
        {
            scrollToFinishActivity();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
