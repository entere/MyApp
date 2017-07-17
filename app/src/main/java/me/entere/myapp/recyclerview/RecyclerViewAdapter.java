package me.entere.myapp.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import me.entere.myapp.R;

/**
 * Created by entere on 17/6/8.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{


    private Context context;
    private ArrayList<ListItem> listItems;


    public RecyclerViewAdapter(Context context, ArrayList<ListItem> listItems) {
        this.context = context;
        this.listItems = listItems;

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tvTitle.setText(listItems.get(position).getTitle());
        holder.tvSummary.setText(listItems.get(position).getSummary());
        holder.tvCategory.setText("以下内容来自「 科技 」栏目");
        holder.tvPublishAt.setText("1小时前");
        //holder.tvName.setText(recyclerViewBean.getName());
        holder.ivImage.setImageResource(listItems.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvSummary;
        TextView tvCategory;
        TextView tvName;
        TextView tvPublishAt;
        ImageView ivImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvSummary = (TextView) itemView.findViewById(R.id.tv_summary);
            tvCategory = (TextView) itemView.findViewById(R.id.tv_category);
            //tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvPublishAt = (TextView) itemView.findViewById(R.id.tv_publish_at);
            ivImage = (ImageView) itemView.findViewById(R.id.iv_image);

        }
    }
}
