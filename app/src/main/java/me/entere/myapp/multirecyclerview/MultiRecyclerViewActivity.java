package me.entere.myapp.multirecyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import me.entere.myapp.R;

public class MultiRecyclerViewActivity extends AppCompatActivity {

    public RecyclerView mRecyclerView;
    public MultiRecyclerViewAdapter mAdapter;
    public ArrayList<DataModel> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_recycler_view);

        initViews();
        initDatas();



    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);//设置导航栏图标
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recycler_view);
        mAdapter = new MultiRecyclerViewAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initDatas() {

        DataModel dataModel1 = new DataModel();

        dataModel1.setType(2);
        dataModel1.setId("1");
        dataModel1.setName("抑郁症");
        dataModel1.setTitle("Woebot：这个聊天机器人要帮人们对抗抑郁症");
        dataModel1.setSummary("聊天机器人收集情感数据，发现一些人类不易察觉的模式。同时，它也会询问一些问题，定期检查病人的状况。");
        dataModel1.setPublishAt("1 小时前");
        dataModel1.setCategory("以下内容来自「科技」栏目");
        dataModel1.setImage(R.mipmap.pic_recycler_view_1);
        mDatas.add(dataModel1);

        DataModel dataModel2 = new DataModel();
        dataModel2.setType(1);
        dataModel2.setId("2");
        dataModel2.setName("年轻人");
        dataModel2.setTitle("宜家跨界有点猛，不仅和苹果玩 AR，还把设计师扔去当宇航员了");
        dataModel2.setSummary("近几年来，宜家合作的设计师类别开始发生改变。在去年的“民主设计日”上，宜家正式宣布和英国鬼才设计师合作。");
        dataModel2.setPublishAt("2 小时前");
        dataModel2.setCategory("以下内容来自「宜家」栏目");
        dataModel2.setImage(R.mipmap.pic_recycler_view_2);
        mDatas.add(dataModel2);

        DataModel dataModel3 = new DataModel();
        dataModel3.setType(2);
        dataModel3.setId("3");
        dataModel3.setName("苹果");
        dataModel3.setTitle("苹果运动鞋要开卖了，40 台 iPhone 7 可能也买不了一双");
        dataModel3.setSummary("乔布斯或许也有一个时尚梦。");
        dataModel3.setPublishAt("3 小时前");
        dataModel3.setCategory("以下内容来自「时尚」栏目");
        dataModel3.setImage(R.mipmap.pic_recycler_view_3);
        mDatas.add(dataModel3);

        DataModel dataModel4 = new DataModel();
        dataModel4.setId("4");
        dataModel4.setType(1);
        dataModel4.setName("特斯拉");
        dataModel4.setTitle("第二季遇严重车祸，特斯拉被中国人推上了五百强榜单");
        dataModel4.setSummary("可怜鼹鼠老兄三次大事故之后，以后真的要小心飙车了。");
        dataModel4.setPublishAt("4 小时前");
        dataModel4.setCategory("以下内容来自「汽车」栏目");
        dataModel4.setImage(R.mipmap.pic_recycler_view_4);
        mDatas.add(dataModel4);


        mAdapter.addListData(mDatas);
        mAdapter.notifyDataSetChanged();

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
}
