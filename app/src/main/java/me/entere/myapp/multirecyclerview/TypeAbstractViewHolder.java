package me.entere.myapp.multirecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by entere on 17/6/13.
 * 每一种布局都封装成一个ViewHolder，继承此类实现BindHolder方法
 */

public abstract class TypeAbstractViewHolder extends RecyclerView.ViewHolder{
    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(DataModel model);
}
