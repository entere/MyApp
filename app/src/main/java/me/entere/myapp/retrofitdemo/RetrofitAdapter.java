package me.entere.myapp.retrofitdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import me.entere.myapp.R;

/**
 * Created by entere on 17/6/19.
 */

public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.MyViewHolder> {

    private Context context;
    public ArrayList<RetrofitBean.Item> list;

    public RetrofitAdapter(Context context, ArrayList<RetrofitBean.Item> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_retrofit,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvSummary.setText(list.get(position).getSummary());
        holder.tvCategory.setText("以下内容来自「 科技 」栏目");
        holder.tvPublishAt.setText("1小时前");
        //holder.tvName.setText(recyclerViewBean.getName());
        holder.ivImage.setImageResource(R.mipmap.pic_recycler_view_1);

        Glide
                .with(context)
                .load(list.get(position).getArticleImg().getUrl())
                .into(holder.ivImage);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

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
