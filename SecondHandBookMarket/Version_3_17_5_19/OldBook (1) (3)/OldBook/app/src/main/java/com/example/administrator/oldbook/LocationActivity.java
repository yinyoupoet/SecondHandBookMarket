package com.example.administrator.oldbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

import static com.example.administrator.oldbook.MainActivity.mToast;

public class LocationActivity extends SwipeBackActivity implements View.OnClickListener
{
    private Button locatedCityButton;
    private String[] cities = {"北京","成都","海口","杭州","济南","上海","桂林","哈尔滨","南京","广州","深圳"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_layout);

        Intent intent = getIntent();
        locatedCityButton = (Button)findViewById(R.id.location_located_button);
        locatedCityButton.setText(intent.getStringExtra("locat"));
        mToast.setText(intent.getStringExtra("locat"));
        mToast.show();

        ImageButton backButton = (ImageButton)findViewById(R.id.location_back_imagebutton);
        backButton.setOnClickListener(this);

        List<String> citiesList = Arrays.asList(cities);
        Collections.sort(citiesList, Collator.getInstance(java.util.Locale.CHINA));
        cities = citiesList.toArray(new String [citiesList.size()]);
        ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(LocationActivity.this,android.R.layout.simple_list_item_1,cities);
        ListView cityListView = (ListView)findViewById(R.id.location_city_listview);
        cityListView.setAdapter(cityAdapter);
        cityListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
           @Override
            public void onItemClick(AdapterView<?> parent,View v,int position,long id)
            {
                toNextStep(cities[position]);
            }
        });

        locatedCityButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.location_located_button :
            {
                toNextStep(locatedCityButton.getText().toString());
                break;
            }
            case R.id.location_back_imagebutton:
            {
                scrollToFinishActivity();
            }
        }
    }

    private void toNextStep(String city)
    {
        Intent intent = new Intent(LocationActivity.this,UniversityActivity.class);
        intent.putExtra("city",city);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent intent)
    {
        switch(requestCode)
        {
            case 1:
            {
                if(resultCode == RESULT_OK)
                {
                    if("Y" == intent.getStringExtra("close"));
                    {
                        scrollToFinishActivity();
                    }

                    return;
                }
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
