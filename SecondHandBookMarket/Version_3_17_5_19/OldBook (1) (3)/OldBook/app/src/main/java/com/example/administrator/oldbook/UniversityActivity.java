package com.example.administrator.oldbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

import static com.example.administrator.oldbook.MainActivity.mToast;


public class UniversityActivity extends SwipeBackActivity implements View.OnClickListener
{
    List<String> universityList =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.university_layout);

        Intent intent = getIntent();
        ustFromCity(intent.getStringExtra("city"));
        TextView universityheadTextView = (TextView)findViewById(R.id.university_head_textview);
        universityheadTextView.setText(intent.getStringExtra("city"));

        ImageButton backButton = (ImageButton)findViewById(R.id.university_back_imagebutton);
        backButton.setOnClickListener(this);

        ListView universityListView = (ListView)findViewById(R.id.university_listview);
        final String[] universities = universityList.toArray(new String[universityList.size()]);
        ArrayAdapter<String> universityAdapter = new ArrayAdapter<String>(UniversityActivity.this,android.R.layout.simple_list_item_1,universities);
        universityListView.setAdapter(universityAdapter);
        universityListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent,View v,int position,long id)
            {
               Intent intent = new Intent();
                intent.putExtra("close","Y");
                setResult(RESULT_OK,intent);
                mToast.setText(universities[position]);
                mToast.show();
                finish();

            }
        });
    }

    private void ustFromCity(String city)
    {
        switch(city)
        {
            case "长沙":
            {
                universityList.add("湖南大学");
                universityList.add("中南大学");
                universityList.add("长沙理工大学（云塘校区）");
                universityList.add("长沙理工大学（金盆岭校区）");
                universityList.add("湖南农业大学");
                universityList.add("湖南中医药大学");
                universityList.add("湖南师范大学");
                universityList.add("湖南科技学院");
                universityList.add("湖南商学院");
                universityList.add("长沙学院");
                universityList.add("湖南财政经济学院");
                universityList.add("湖南警察学院");
                universityList.add("湖南女子学院");
                universityList.add("湖南第一师范学院");
                universityList.add("长沙师范学院");
                universityList.add("湖南涉外经济学院");
                universityList.add("湖南财政经济学院");
                universityList.add("湖南税务高等专科学校");
                universityList.add("长沙航空职业技术学院");
                universityList.add("长沙民政职业技术学院");
                universityList.add("湖南工业职业技术学院");
                universityList.add("湖南信息职业技术学院");
                universityList.add("湖南生物机电职业技术学院");
                universityList.add("湖南外贸职业学院");
                universityList.add("湖南邮电职业技术学院");
                universityList.add("湖南外国语职业学院");
                universityList.add("湖南都市职业学院");
                universityList.add("保险职业学院");
                universityList.add("湖南三一工业职业技术学院");
                universityList.add("长沙卫生职业学院");
                universityList.add("湖南食品药品职业学院");
                universityList.add("湖南大众传媒职业技术学院");
                universityList.add("湖南科技职业学院");
                universityList.add("湖南交通职业技术学院");
                universityList.add("湖南商务职业技术学院");
                universityList.add("湖南体育职业学院");
                universityList.add("湖南工程职业技术学院");
                universityList.add("湖南网络工程职业学院");
                universityList.add("湖南司法警官职业学院");
                universityList.add("长沙商贸旅游职业技术学院");
                universityList.add("长沙环境保护职业技术学院");
                universityList.add("湖南艺术职业学院");
                universityList.add("湖南机电职业技术学院");
                universityList.add("长沙职业技术学院");
                universityList.add("长沙南方职业学院");
                universityList.add("湖南机电职业技术学院");
                universityList.add("湖南信息科学职业学院");
                universityList.add("长沙电力职业技术学院");
                universityList.add("湖南水利水电职业技术学院");
                universityList.add("湖南现代物流职业技术学院");
                universityList.add("湖南安全技术职业学院");
                break;
            }
            case "北京":
            {
                universityList.add("北京大学");
                universityList.add("清华大学");
                universityList.add("中国人民大学");
                universityList.add("北京师范大学");
                universityList.add("北京航空航天大学");
                universityList.add("中国农业大学");
                universityList.add("北京协和医学院");
                universityList.add("北京理工大学");
                universityList.add("中国矿业大学（北京校区）");
                universityList.add("北京科技大学");
                universityList.add("北京交通大学");
                universityList.add("北京化工大学");
                universityList.add("北京林业大学");
                universityList.add("中国政法大学");
                universityList.add("北京邮电大学");
                universityList.add("北京工业大学");
                universityList.add("首都医科大学");
                universityList.add("中央民族大学");
                universityList.add("首都师范大学");
                universityList.add("中央财经大学");
                universityList.add("北京中医药大学");
                universityList.add("对外经济贸易大学");
                universityList.add("中国传媒大学");
                universityList.add("北京外国语大学");
                universityList.add("首都经济贸易大学");
                universityList.add("北京语言大学");
                universityList.add("北京工商大学");
                universityList.add("北京建筑大学");
                universityList.add("北方工业大学");
                universityList.add("外交学院");
                universityList.add("国际关系学院");
                universityList.add("北京信息科技大学");
                universityList.add("北京联合大学");
                universityList.add("北京第二外国语学院");
                universityList.add("北京农学院");
                universityList.add("北京服装学院");
                universityList.add("中国青年政治学院");
                universityList.add("北京印刷学院");
                universityList.add("北京物资学院");
                universityList.add("北京电子科技学院");
                universityList.add("北京石油化工学院");
                universityList.add("首钢工学院");
                universityList.add("中国劳动关系学院");
                universityList.add("中华女子学院");
                universityList.add("中国地质大学（北京校区）");
                universityList.add("北京邮电大学（宏福校区）");
                universityList.add("中央音乐学院");
                universityList.add("北京大学医学部");
                universityList.add("中国石油大学（北京校区）");
                universityList.add("北京体育大学");
                universityList.add("华北电力大学（北京校区）");
                universityList.add("首都师范大学科德学院");
                universityList.add("北京财贸职业学院");
                universityList.add("北京警察学院");
                universityList.add("北京经济管理职业学院");
                universityList.add("北京经济技术职业学院");
                universityList.add("北京科技职业学院");
                universityList.add("北京电子科技职业学院");
                universityList.add("北京现代职业技术学院");
                universityList.add("北京艺术传媒职业学院");
                universityList.add("北京戏曲艺术职业学院");
                universityList.add("北京工业大学耿丹学院");
                universityList.add("北京吉利学院");
                universityList.add("北京交通职业技术学院");
                universityList.add("北京第二外国语学院中瑞酒店管理学院");
                universityList.add("北京京北职业技术学院");
                universityList.add("中国音乐学院");
                universityList.add("中国戏曲学院");
                universityList.add("解放军国防大学");
                universityList.add("中国人民公安大学");
                universityList.add("北京卫生职业学院");
                universityList.add("北京交通运输职业学院");
                universityList.add("北京体育职业学院");
                universityList.add("北京工商大学嘉华学院");
                universityList.add("北京汇佳职业学院");
                universityList.add("北京培黎职业学院");
                universityList.add("北京邮电大学世纪学院");
                universityList.add("北京科技大学延庆分校");
                universityList.add("北京劳动保障职业学院");
                universityList.add("北京社会管理职业学院");
                universityList.add("北京政法职业学院");
                universityList.add("北京经贸职业学院");
                universityList.add("北京工业职业技术学院");
                universityList.add("北京信息职业技术学院");
                universityList.add("北京科技经营管理学院");
                universityList.add("北京农业职业学院");
                universityList.add("北京城市学院");
                universityList.add("北京青年政治学院");
                universityList.add("首都体育学院");
                universityList.add("中央美术学院");
                universityList.add("北京电影学院");
                universityList.add("北京舞蹈学院");
                universityList.add("解放军北京机械士官学校");
                break;
            }
            case "成都":
            {
                universityList.add("四川大学");
                universityList.add("西南交通大学");
                universityList.add("电子科技大学");
                universityList.add("西南石油大学");
                universityList.add("成都理工大学");
                universityList.add("成都信息工程大学");
                universityList.add("西华大学");
                universityList.add("成都中医药大学");
                universityList.add("四川师范大学");
                universityList.add("西南财经大学");
                universityList.add("成都体育学院");
                universityList.add("四川音乐学院");
                universityList.add("西南民族大学");
                universityList.add("成都学院");
                universityList.add("成都工业学院");
                universityList.add("四川旅游学院");
                universityList.add("成都东软学院");
                universityList.add("电子科技大学成都学院");
                universityList.add("四川传媒学院");
                universityList.add("成都信息工程大学银杏酒店管理学院");
                universityList.add("成都文理学院");
                universityList.add("四川工商学院");
                universityList.add("四川外国语大学成都学院");
                universityList.add("成都医学院");
                universityList.add("四川大学锦城学院");
                universityList.add("成都师范学院");
                universityList.add("四川电影电视学院");
                universityList.add("成都纺织高等专科学校");
                universityList.add("四川天一学院");
                universityList.add("成都航空职业技术学院");
                universityList.add("四川电力职业技术学院");
                universityList.add("成都职业技术学院");
                universityList.add("四川水利职业技术学院");
                universityList.add("四川航天职业技术学院");
                universityList.add("四川邮电职业技术学院");
                universityList.add("四川交通职业技术学院");
                universityList.add("四川工商职业技术学院");
                universityList.add("四川托普信息技术职业学院");
                universityList.add("四川国际标榜职业学院");
                universityList.add("成都农业科技职业学院");
                universityList.add("成都艺术职业学院");
                universityList.add("四川商务职业学院");
                universityList.add("四川文化传媒职业学院");
                universityList.add("四川华新现代职业学院");
                universityList.add("四川管理职业学院");
                universityList.add("四川艺术职业学院");
                universityList.add("四川科技职业学院");
                universityList.add("四川文化产业职业学院");
                universityList.add("四川财经职业学院");
                universityList.add("四川城市职业学院");
                universityList.add("四川现代职业学院");
                universityList.add("四川长江职业学院");
                universityList.add("四川文轩职业学院");
                universityList.add("成都工业职业技术学院");
                universityList.add("四川西南航空职业学院");
                universityList.add("成都工贸职业技术学院");
                break;
            }
            case "广州":
            {

                universityList.add("中山大学");
                universityList.add("暨南大学");
                universityList.add("华南理工大学");
                universityList.add("华南农业大学");
                universityList.add("广州医科大学");
                universityList.add("广州中医药大学");
                universityList.add("广东药科大学");
                universityList.add("华南师范大学");
                universityList.add("广州体育学院");
                universityList.add("广州美术学院");
                universityList.add("星海音乐学院");
                universityList.add("广东技术师范学院");
                universityList.add("广东财经大学");
                universityList.add("广东白云学院");
                universityList.add("广州大学");
                universityList.add("广州航海学院");
                universityList.add("广东警官学院");
                universityList.add("仲恺农业工程学院");
                universityList.add("广东金融学院");
                universityList.add("广东工业大学");
                universityList.add("广东外语外贸大学");
                universityList.add("广东培正学院");
                universityList.add("南方医科大学");
                universityList.add("华南理工大学广州学院");
                universityList.add("广州大学华软软件学院");
                universityList.add("中山大学南方学院");
                universityList.add("广东外语外贸大学南国商学院");
                universityList.add("广东财经大学华商学院");
                universityList.add("华南农业大学珠江学院");
                universityList.add("广东技术师范学院天河学院");
                universityList.add("广东工业大学华立学院");
                universityList.add("广州大学松田学院");
                universityList.add("广州商学院");
                universityList.add("广州工商学院");
                universityList.add("中山大学新华学院");
                universityList.add("广东第二师范学院");
                universityList.add("广东轻工职业技术学院");
                universityList.add("广东交通职业技术学院");
                universityList.add("广东水利电力职业技术学院");
                universityList.add("民办南华工商学院");
                universityList.add("私立华联学院");
                universityList.add("广州民航职业技术学院");
                universityList.add("广州番禺职业技术学院");
                universityList.add("广东农工商职业技术学院");
                universityList.add("广东科学技术职业学院");
                universityList.add("广东食品药品职业学院");
                universityList.add("广州康大职业技术学院");
                universityList.add("广东行政职业学院");
                universityList.add("广东体育职业技术学院");
                universityList.add("广东建设职业技术学院");
                universityList.add("广东女子职业技术学院");
                universityList.add("广东机电职业技术学院");
                universityList.add("广东岭南职业技术学院");
                universityList.add("广东邮电职业技术学院");
                universityList.add("广东工贸职业技术学院");
                universityList.add("广东司法警官职业学院");
                universityList.add("广东省外语艺术职业学院");
                universityList.add("广东文艺职业学院");
                universityList.add("广州体育职业技术学院");
                universityList.add("广州工程技术职业学院");
                universityList.add("广州涉外经济职业技术学院");
                universityList.add("广州南洋理工职业学院");
                universityList.add("广州科技职业技术学院");
                universityList.add("广州现代信息工程职业技术学院");
                universityList.add("广东理工职业学院");
                universityList.add("广州华南商贸职业学院");
                universityList.add("广州华立科技职业学院");
                universityList.add("广州城市职业学院");
                universityList.add("广东工程职业技术学院");
                universityList.add("广州铁路职业技术学院");
                universityList.add("广东科贸职业学院");
                universityList.add("广州科技贸易职业学院");
                universityList.add("广州珠江职业技术学院");
                universityList.add("广州松田职业学院");
                universityList.add("广州城建职业学院");
                universityList.add("广州华商职业学院");
                universityList.add("广州华夏职业学院");
                universityList.add("广东青年职业学院");
                universityList.add("广州东华职业学院");
                universityList.add("广东舞蹈戏剧职业学院");
                universityList.add("广东生态工程职业学院");
                universityList.add("公安边防部队高等专科学校");
                universityList.add("广州卫生职业技术学院");
                break;
            }
        }
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.university_back_imagebutton:
            {
                scrollToFinishActivity();
                break;
            }
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
