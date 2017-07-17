package me.entere.myapp.swipe;

import android.app.ActivityOptions;
import android.content.Intent;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;

import java.util.ArrayList;
import java.util.List;

import me.entere.myapp.R;
import me.entere.myapp.webview.WebviewActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

import static me.entere.myapp.R.id.card_view;

public class SwipeActivity extends AppCompatActivity implements OnRefreshListener,OnLoadMoreListener{

    public SwipeToLoadLayout swipeToLoadLayout;
    public ArrayList<SwipeBean.Item> list = new ArrayList<>();
    public RecyclerView mRecyclerView;
    public SwipeAdapter mAdapter;


    private int pages=1;

    private final int TOP_REFRESH = 1;
    private final int BOTTOM_REFRESH = 2;

    public long firstTime=0;
    public long lastTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);


        //initDatas();

        initViews();




    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);//设置导航栏图标

        swipeToLoadLayout = (SwipeToLoadLayout) findViewById(R.id.swipeToLoadLayout);

        mRecyclerView = (RecyclerView) findViewById(R.id.swipe_target);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);

        mAdapter = new SwipeAdapter(this,list);

        mRecyclerView.setAdapter(mAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        initDatas(0,0);
        mAdapter.setOnItemClickListener(new MyOnItemClickListener());

    }

    private void initDatas(long firstTime,long lastTime) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sr.blogchina.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SwipeApi swipeApi = retrofit.create(SwipeApi.class);
        Call<SwipeBean> call = swipeApi.getData(31,"no",firstTime,lastTime);
        call.enqueue(new Callback<SwipeBean>() {
            @Override
            public void onResponse(Call<SwipeBean> call, Response<SwipeBean> response) {
                try {
                    if(response.body().data.items.size()>0) {
                        //List<SwipeBean.Item> arrayList = response.body().data.items;
                        list.addAll(response.body().data.items);
                        mAdapter.notifyDataSetChanged();
                    }

                } catch (Exception e) {

                    Log.i("server_error", "eeeee");
                }


            }

            @Override
            public void onFailure(Call<SwipeBean> call, Throwable t) {
                Log.i("retrofit_error", t.getMessage());
            }
        });
    }

    private void dataOption(int option){
        switch (option) {
            case TOP_REFRESH:
                //下拉刷新
                //list.clear();
                firstTime = mAdapter.getTopArticlePublishAt();
                lastTime = 0;
                initDatas(firstTime,lastTime);
                break;
            case BOTTOM_REFRESH:
                //上拉加载更多
                //pages++;
                firstTime = 0;
                lastTime = mAdapter.getBottomArticlePublishAt();
                initDatas(firstTime,lastTime);
                break;
        }
        // mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onRefresh() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(false);
                dataOption(TOP_REFRESH);
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);
                dataOption(BOTTOM_REFRESH);
            }
        }, 1000);
    }




    private void autoRefresh() {
        swipeToLoadLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(true);
            }
        });
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



    /**
     * 点击Item
     */
    private class MyOnItemClickListener implements SwipeAdapter.OnItemClickListener {



        @Override
        public void onItemClick(View view, int position) {

            Long aid = list.get(position).getAid();
            String title = list.get(position).getTitle();
            String summary = list.get(position).getSummary();
            Long publishAt = list.get(position).getAddTime();
            Intent intent = new Intent(SwipeActivity.this,WebviewActivity.class);
            intent.putExtra("extraAid",aid);
            intent.putExtra("extraTitle",title);
            intent.putExtra("extraSummary",summary);
            intent.putExtra("extraPublishAt",publishAt);

            //startActivity(intent);
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(SwipeActivity.this,(TextView) findViewById(R.id.tv_title),"shareTvTitle").toBundle());

        }
    }

}
