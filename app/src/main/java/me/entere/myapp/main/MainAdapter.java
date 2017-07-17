package me.entere.myapp.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import me.entere.myapp.mygesturedetector.MyGestureDetectorActivity;
import me.entere.myapp.R;
import me.entere.myapp.iconfont.IconfontActivity;
import me.entere.myapp.multirecyclerview.MultiRecyclerViewActivity;
import me.entere.myapp.mymatisse.MyMatisseActivity;
import me.entere.myapp.recyclerview.RecyclerViewActivity;
import me.entere.myapp.retrofitdemo.RetrofitActivity;
import me.entere.myapp.swipe.SwipeActivity;

/**
 * Created by entere on 17/6/30.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    static final int VIEW_TYPE_HEADER = 0;
    static final int VIEW_TYPE_NORMAL = 1;

    private Context context;
    public ArrayList<ListItem> listItems = new ArrayList<>();



    public MainAdapter(Context context, ArrayList<ListItem> listItems) {
        this.context = context;
        this.listItems = listItems;
        listItems.add(new ListItem(0,1,"Android Demo"));
        listItems.add(new ListItem(1,1,"RecyclerView 简单布局",R.color.red, RecyclerViewActivity.class));
        listItems.add(new ListItem(1,2,"RecyclerView 多列布局",R.color.green,MultiRecyclerViewActivity.class));
        listItems.add(new ListItem(1,3,"Retrofit 简单布局",R.color.yellow,RetrofitActivity.class));
        listItems.add(new ListItem(1,4,"Swipe 实现上拉、下拉",R.color.magenta,SwipeActivity.class));
        listItems.add(new ListItem(1,5,"Iconfont 示例",R.color.aqua,IconfontActivity.class));
        listItems.add(new ListItem(1,6,"简单手势 示例",R.color.powderblue,MyGestureDetectorActivity.class));
        listItems.add(new ListItem(1,7,"图片选择器Matisse",R.color.darkolivegreen,MyMatisseActivity.class));

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_HEADER:
                return new HeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_header, parent, false));
            case VIEW_TYPE_NORMAL:
                return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false));

        }
        return null;


    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return listItems.get(position).getViewType();
        //return super.getItemViewType(position);
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        ImageView ivImage;
        public ItemViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            ivImage = (ImageView) itemView.findViewById(R.id.iv_image);

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_HEADER:
                ((HeaderViewHolder) holder).tvCategory.setText(listItems.get(position).getCategory());
                break;
            case VIEW_TYPE_NORMAL:
                ((ItemViewHolder) holder).tvTitle.setText(listItems.get(position).getTitle());
                ((ItemViewHolder) holder).ivImage.setImageResource(listItems.get(position).getImageRes());
                break;
            default:
                break;

        }


    }


    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategory;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            tvCategory = (TextView) itemView.findViewById(R.id.tv_category);

        }
    }



    Class<?> getActivityClass(int position) {



        try {
            String name = listItems.get(position).getActivityClassName();
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //return null;

        }

        return null;




    }



}
