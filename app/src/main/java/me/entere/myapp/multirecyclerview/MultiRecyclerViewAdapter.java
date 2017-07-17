package me.entere.myapp.multirecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;


import me.entere.myapp.R;


/**
 * Created by entere on 17/6/13.
 */

public class MultiRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<DataModel> mDatas = new ArrayList<>();
    private LayoutInflater mLayoutInflater;


    public MultiRecyclerViewAdapter(Context mContext) {

        mLayoutInflater = LayoutInflater.from(mContext);
    }

    /**
     * 创建一个方法供外面操作此数据
     * @param list
     */
    public void addListData(ArrayList<DataModel> list) {
        mDatas.addAll(list);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {

            case DataModel.TYPE_ONE:
                return new TypeOneViewHolder(mLayoutInflater.inflate(R.layout.item_multi_recycler_view_one,parent,false));

            case DataModel.TYPE_TOW:
                return new TypeTwoViewHolder(mLayoutInflater.inflate(R.layout.item_multi_recycler_view_two,parent,false));

        }
        return null;


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TypeAbstractViewHolder)holder).bindHolder(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mDatas.get(position).type;
    }
}


