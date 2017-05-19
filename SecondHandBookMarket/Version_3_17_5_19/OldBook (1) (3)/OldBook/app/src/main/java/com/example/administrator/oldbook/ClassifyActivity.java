package com.example.administrator.oldbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

import static com.example.administrator.oldbook.MainActivity.mToast;

public class ClassifyActivity extends SwipeBackActivity implements View.OnClickListener
{

    private List<Book_Classify_Adapter> booklist = new ArrayList<Book_Classify_Adapter>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify);

        Intent intent = getIntent();
        mToast.setText(intent.getStringExtra("classify"));
        mToast.show();

        ImageButton backImageButton = (ImageButton) findViewById(R.id.classify_back_imagebutton);     // 返回按键
        ImageButton searchImageButton = (ImageButton) findViewById(R.id.classify_search_imagebutton);     // 搜索按键

        backImageButton.setOnClickListener(this);
        searchImageButton.setOnClickListener(this);

        Init(intent.getStringExtra("classify"));
    }

    public void Init(String classify)
    {
        switch(classify)
        {
            case "Science" :
            {
                classifyScience();
                break;
            }
            case "Engineering":
            {
                classifyEngineering();
                break;
            }
            case "Arts":
            {
                classifyArts();
                break;
            }
            case "Other":
            {
                classifyOther();
                break;
            }
            default:
                break;
        }
    }

    private void classifyScience()
    {
        //分类列表显示
        Book_Classify_Adapter book_classify_adapter = new Book_Classify_Adapter("高等数学同济第七版", R.drawable.eg_math);
        booklist.add(book_classify_adapter);

        ListView BookListView = (ListView) findViewById(R.id.Classify_ListView);
        Book_Adapter_Class book_adapter_class = new Book_Adapter_Class(ClassifyActivity.this, R.layout.book_classify_layout, booklist);
        BookListView.setAdapter(book_adapter_class);
    }

    private void classifyEngineering()
    {

    }

    private void classifyArts()
    {

    }

    private void classifyOther()
    {

    }

    @Override
    public void onClick(View v)         //点击事件
    {
        switch (v.getId()) {
            case R.id.classify_back_imagebutton:      //返回按键事件
            {
                scrollToFinishActivity();
                break;
            }
            case R.id.classify_search_imagebutton:      //搜索按键事件
            {

                break;
            }
            default:
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
