package me.entere.myapp.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

import me.entere.myapp.R;


public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerViewAdapter mAdapter;

    private RecyclerView mRecyclerView;


    public ArrayList<ListItem> listItems = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initDatas();
        initViews();








    }



    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);//设置导航栏图标

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recycler_view);


        mRecyclerView.setAdapter(mAdapter = new RecyclerViewAdapter(this,listItems));

        //设置RecyclerView的布局管理
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);



    }









    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    private void initDatas() {

        ListItem listItem1 = new ListItem();
        listItem1.setId("1");
        listItem1.setName("抑郁症");
        listItem1.setTitle("Woebot：这个聊天机器人要帮人们对抗抑郁症");
        listItem1.setSummary("聊天机器人收集情感数据，发现一些人类不易察觉的模式。同时，它也会询问一些问题，定期检查病人的状况。");
        listItem1.setPublishAt("1 小时前");
        listItem1.setCategory("以下内容来自「科技」栏目");
        listItem1.setImage(R.mipmap.pic_recycler_view_1);
        listItems.add(listItem1);

        ListItem listItem2 = new ListItem();
        listItem2.setId("2");
        listItem2.setName("年轻人");
        listItem2.setTitle("宜家跨界有点猛，不仅和苹果玩 AR，还把设计师扔去当宇航员了");
        listItem2.setSummary("近几年来，宜家合作的设计师类别开始发生改变。在去年的“民主设计日”上，宜家正式宣布和英国鬼才设计师合作。");
        listItem2.setPublishAt("2 小时前");
        listItem2.setCategory("以下内容来自「宜家」栏目");
        listItem2.setImage(R.mipmap.pic_recycler_view_2);
        listItems.add(listItem2);

        ListItem listItem3 = new ListItem();
        listItem3.setId("3");
        listItem3.setName("苹果");
        listItem3.setTitle("苹果运动鞋要开卖了，40 台 iPhone 7 可能也买不了一双");
        listItem3.setSummary("乔布斯或许也有一个时尚梦。");
        listItem3.setPublishAt("3 小时前");
        listItem3.setCategory("以下内容来自「时尚」栏目");
        listItem3.setImage(R.mipmap.pic_recycler_view_3);
        listItems.add(listItem3);

        ListItem listItem4 = new ListItem();
        listItem4.setId("4");
        listItem4.setName("特斯拉");
        listItem4.setTitle("第二季遇严重车祸，特斯拉被中国人推上了五百强榜单");
        listItem4.setSummary("可怜鼹鼠老兄......三次大事故之后，以后真的要小心飙车了。");
        listItem4.setPublishAt("4 小时前");
        listItem4.setCategory("以下内容来自「汽车」栏目");
        listItem4.setImage(R.mipmap.pic_recycler_view_4);
        listItems.add(listItem4);
    }

}
