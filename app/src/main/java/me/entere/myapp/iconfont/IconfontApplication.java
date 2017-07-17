package me.entere.myapp.iconfont;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by entere on 17/6/22.
 */

public class IconfontApplication extends Application{

    public static Typeface iconfont;

    public static Typeface getIconfont(Context context) {
        if(iconfont != null ) {
            return iconfont;

        } else {
            iconfont = Typeface.createFromAsset(context.getAssets(),"iconfont/iconfont.ttf");
        }
        return iconfont;
    }
}
