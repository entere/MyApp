package me.entere.myapp.mygesturedetector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

import me.entere.myapp.R;

public class MyGestureDetectorActivity extends AppCompatActivity {

    private GestureDetector mGestureDetector;

    static final String TAG = "MyGestureDetectorActivity";

    private static final int SWIPE_MIN_DISTANCE = 10;
    private static final int SWIPE_THRESHOLD_VELOCITY = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_gesture_detector);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);//设置导航栏图标


        mGestureDetector = new GestureDetector(this, new MyOnGestureListener());


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }


    private class MyOnGestureListener implements GestureDetector.OnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            float xAbs = Math.abs(e2.getX()-e1.getX());
            float yAbs = Math.abs(e2.getY()-e1.getY());
            if(xAbs > yAbs) {
                //左右滑动
                if ((e1.getX() - e2.getX()) > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    Toast.makeText(getApplicationContext(),"left",Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(getApplicationContext(),WebviewActivity.class));
                    Log.e(TAG, "onFling left");

                } else if ((e2.getX() - e1.getX()) > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    Toast.makeText(getApplicationContext(),"right",Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(getApplicationContext(),IconfontActivity.class));
                    Log.e(TAG, "onFling right");


                }

            }else {
                //上下滑动

                if ((e1.getY() - e2.getY()) > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                    Toast.makeText(getApplicationContext(),"up",Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(getApplicationContext(),WebviewActivity.class));
                    Log.e(TAG, "onFling up");

                } else if ((e2.getY() - e1.getY()) > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                    Toast.makeText(getApplicationContext(),"down",Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(getApplicationContext(),IconfontActivity.class));
                    Log.e(TAG, "onFling down");


                }
            }


            return false;
        }
    }


    //解决滑动冲突
    public boolean dispatchTouchEvent(MotionEvent ev) {
        mGestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
