package me.entere.myapp.swipe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;


import java.util.ArrayList;

import me.entere.myapp.R;

import static com.bumptech.glide.Glide.with;

/**
 * Created by entere on 17/6/20.
 */

public class SwipeAdapter extends RecyclerView.Adapter<SwipeAdapter.MyViewHolder>{
    public ArrayList<SwipeBean.Item> list;
    public Context context;

    private OnItemClickListener mOnItemClickListener = null;


    public SwipeAdapter(Context context, ArrayList<SwipeBean.Item> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public SwipeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_swipe,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(SwipeAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvSummary.setText(list.get(position).getSummary());
        holder.tvCategory.setText("以下内容来自「 科技 」栏目");
        holder.tvPublishAt.setText("1小时前");
        //holder.tvName.setText(recyclerViewBean.getName());
        //holder.ivImage.setImageResource(R.mipmap.pic_recycler_view_1);

        Glide
                .with(context)

                .load(list.get(position).getArticleImg().getUrl())

                .apply(SwipeGlideRequestOptions.getRequestOptions())
                .transition(new DrawableTransitionOptions().crossFade())

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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mOnItemClickListener!=null){
                        mOnItemClickListener.onItemClick(v,getPosition());
                    }
                }
            });

        }
    }




    //返回最底部的文章发表时间，加载更多时查询小于这个时间的文章
    public Long getBottomArticlePublishAt() {
        if (list == null || list.size() == 0)
            return Long.valueOf(0);
        return list.get(list.size() - 1).getAddTime();
    }

    //返回最顶部的文章发表时间，下拉刷新时查询大于这个时间的文章
    public Long getTopArticlePublishAt() {
        if (list == null || list.size() == 0)
            return Long.valueOf(0);
        return list.get(0).getAddTime();
    }



    //给RecyclerView注册点击回调接口
    public interface  OnItemClickListener {
        void onItemClick(View view,int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }
}
