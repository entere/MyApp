package me.entere.myapp.iconfont;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;



/**
 * TODO: document your custom view class.
 */
public class MyIconTextView extends AppCompatTextView {

    public MyIconTextView(Context context) {
        super(context);
        init(context);
    }

    public MyIconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyIconTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setTypeface(IconfontApplication.getIconfont(context));
    }
}