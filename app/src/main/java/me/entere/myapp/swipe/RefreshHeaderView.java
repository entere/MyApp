package me.entere.myapp.swipe;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeRefreshTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;

/**
 * Created by entere on 17/6/20.
 */

public class RefreshHeaderView extends TextView implements SwipeTrigger,SwipeRefreshTrigger {
    public RefreshHeaderView(Context context) {
        super(context);
    }

    public RefreshHeaderView(Context context, AttributeSet attrs) {
        super(context,attrs);

    }

    @Override
    public void onRefresh() {
        setText("REFRESHING");

    }

    @Override
    public void onPrepare() {
        setText("");

    }

    @Override
    public void onMove(int yScrolled, boolean isComplete, boolean automatic) {
        if (!isComplete) {
            if (yScrolled >= getHeight()) {
                setText("RELEASE TO REFRESH");
            } else {
                setText("SWIPE TO REFRESH");
            }
        } else {
            setText("REFRESH RETURNING");
        }
    }

    @Override
    public void onRelease() {

    }

    @Override
    public void onComplete() {
        setText("COMPLETE");
    }

    @Override
    public void onReset() {
        setText("");
    }
}
