package me.entere.myapp.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

import me.entere.myapp.swipe.SwipeAdapter;

/**
 * Created by entere on 17/7/3.
 * 实现点击事件监听
 */

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener{
    private OnItemClickListener mListener;
    private GestureDetector mGestureDetector;

    // 点击回调
    public interface OnItemClickListener {
        public void onItemClick(View view, int position);

        public void onItemLongClick(View view, int position);
    }

    public RecyclerItemClickListener(Context context,
                                     final RecyclerView recyclerView, OnItemClickListener listener) {
        mListener = listener;
        // 识别并处理手势
        mGestureDetector = new GestureDetector(context,
                new GestureDetector.SimpleOnGestureListener() { ////这里选择SimpleOnGestureListener实现类，可以根据需要选择重写的方法
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        // 轻击触摸屏后,弹起，必须返回true，否则无法触发单击
                        View childView = recyclerView.findChildViewUnder(
                                e.getX(),e.getY());
                        if(childView != null && mListener != null){
                            mListener.onItemClick(childView,recyclerView.getChildLayoutPosition(childView));
                            return true;
                        }
                        return false;

                    }

                    @Override
                    public void onLongPress(MotionEvent e) {
                        // 长按
                        // 根据findChildViewUnder(float x, float y)来算出哪个item被选择了
                        View childView = recyclerView.findChildViewUnder(
                                e.getX(), e.getY());
                        // 有item被选则且监听器不为空触发长按事件
                        if (childView != null && mListener != null) {
                            mListener.onItemLongClick(childView,
                                    recyclerView.getChildLayoutPosition(childView));
                        }
                    }
                });
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        if(mGestureDetector.onTouchEvent(e)) {
            return true;
        } else {
            return false;
        }


    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
