package me.entere.myapp.multirecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import me.entere.myapp.R;

/**
 * Created by entere on 17/6/13.
 */

public class TypeOneViewHolder extends TypeAbstractViewHolder{
    TextView tvTitle;
    TextView tvSummary;
    TextView tvCategory;
    TextView tvName;
    TextView tvPublishAt;
    ImageView ivImage;

    public TypeOneViewHolder(View itemView) {
        super(itemView);

        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        tvSummary = (TextView) itemView.findViewById(R.id.tv_summary);
        tvCategory = (TextView) itemView.findViewById(R.id.tv_category);

        tvPublishAt = (TextView) itemView.findViewById(R.id.tv_publish_at);
        ivImage = (ImageView) itemView.findViewById(R.id.iv_image);;
    }

    @Override
    public void bindHolder(DataModel dataModel) {
        tvTitle.setText(dataModel.getTitle());
        tvSummary.setText(dataModel.getSummary());
        tvCategory.setText(dataModel.getCategory());
        tvPublishAt.setText(dataModel.getPublishAt());
        ivImage.setImageResource(dataModel.getImage());

    }
}
