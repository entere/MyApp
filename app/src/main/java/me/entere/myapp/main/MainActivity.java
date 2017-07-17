package me.entere.myapp.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.view.View;

import java.util.ArrayList;

import me.entere.myapp.R;
import me.entere.myapp.iconfont.IconfontActivity;

public class MainActivity extends AppCompatActivity {

    public MainAdapter mAdapter;

    public RecyclerView mRecyclerView;
    public ArrayList<ListItem> listItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recycler_view);
        mAdapter = new MainAdapter(this,listItems);

        final GridLayoutManager mGridLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int itemViewType = mAdapter.getItemViewType(position);
                return itemViewType == MainAdapter.VIEW_TYPE_HEADER ? 2 : 1;
            }
        });
        int spanCount = 2;//跟布局里面的spanCount属性是一致的
        int spacing = 16;//每一个矩形的间距
        boolean includeEdge = true;//如果设置成false那边缘地带就没有间距
        //设置每个item间距
        //mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount,spacing,includeEdge));
        final float spaceSize = ScreenUtil.dp2px(4, this);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration(){
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int adapterPosition = parent.getChildViewHolder(view).getAdapterPosition();
                GridLayoutManager.SpanSizeLookup spanSizeLookup = mGridLayoutManager.getSpanSizeLookup();
                int spanSize = spanSizeLookup.getSpanSize(adapterPosition);
                if (spanSize == 2) {
                    return;
                }
                int spanIndex = spanSizeLookup.getSpanIndex(adapterPosition, mGridLayoutManager.getSpanCount());
                if (spanIndex == 0) {
                    outRect.set((int) spaceSize, (int) spaceSize, ((int) (spaceSize / 2)), 0);
                } else {
                    outRect.set(((int) (spaceSize / 2)), (int) spaceSize, (int) spaceSize, 0);
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if(mAdapter.getActivityClass(position) != null) {
                    startActivity(new Intent(getApplication(), mAdapter.getActivityClass(position)));
                }
                return;
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));











    }

    public static class ScreenUtil {
        public static float dp2px(int dip, Context context) {
            float scale = context.getResources().getDisplayMetrics().density;
            return dip * scale + 0.5f;
        }
    }

    
}
