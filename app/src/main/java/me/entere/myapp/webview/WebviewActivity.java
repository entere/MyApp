package me.entere.myapp.webview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import me.entere.myapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.widget.Toast.LENGTH_LONG;
import static me.entere.myapp.R.menu.menu_webview;

public class WebviewActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvSummary;
    TextView tvCategory;
    TextView tvName;
    TextView tvPublishAt;
    ImageView ivImage;
    WebView wvContent;
    LinearLayout mLinearLayout;

    public GestureDetector mGestureDetector;
    protected static final float FLIP_DISTANCE = 50;



    private long extraAid;
    private String extraTitle;
    private String extraSummary;
    private String extraPublishAt;
    private String extraName;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        initExtra();
        initViews();

        initDatas();
    }

    private void initExtra() {
        extraAid =  getIntent().getLongExtra("extraAid",0);
        extraTitle = getIntent().getStringExtra("extraTitle");
        extraSummary = getIntent().getStringExtra("extraSummary");
        extraPublishAt = getIntent().getStringExtra("extraPublishAt");


    }

    private void initViews() {

        mGestureDetector = new GestureDetector(this,new MyGestureListener());

        View decorView = getWindow().getDecorView();
        decorView = (View) findViewById(R.id.ll_content);

        decorView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mGestureDetector.onTouchEvent(event);
                //Toast.makeText(getApplicationContext(),"ooo",Toast.LENGTH_SHORT).show();

            }
        });
        decorView.setLongClickable(true);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);//设置导航栏图标


        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvSummary = (TextView) findViewById(R.id.tv_summary);
        //tvCategory = (TextView) findViewById(R.id.tv_category);
        //tvName = (TextView) findViewById(R.id.tv_name);
        tvPublishAt = (TextView) findViewById(R.id.tv_publish_at);
        ivImage = (ImageView) findViewById(R.id.iv_image);
        wvContent = (WebView) findViewById(R.id.wv_content);


        tvTitle.setText(extraTitle);
        tvSummary.setText(extraSummary);


    }





    private void initDatas() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sr.blogchina.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebViewApi webViewApi = retrofit.create(WebViewApi.class);
        Call<WebViewBean> call = webViewApi.getData(extraAid);
        call.enqueue(new Callback<WebViewBean>() {
            @Override
            public void onResponse(Call<WebViewBean> call, Response<WebViewBean> response) {

                try {
                    String content = response.body().data.detail.getContent();
                    if(20==20) {

                        Log.i("webviewdata",response.body().data.detail.getContent());

                        //List<SwipeBean.Item> arrayList = response.body().data.items;
//                        list.addAll(response.body().data.items);
//                        mAdapter.notifyDataSetChanged();
                        wvContent.getSettings().setJavaScriptEnabled(true);
                        wvContent.getSettings().setBlockNetworkImage(false);
                        wvContent.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                        // 开启DOM storage API 功能
                        wvContent.getSettings().setDomStorageEnabled(true);
                        // 开启database storage API功能
                        wvContent.getSettings().setDatabaseEnabled(true);
                        // 开启Application Cache功能
                        wvContent.getSettings().setAppCacheEnabled(true);
                        wvContent.getSettings().setSupportZoom(true);
                        wvContent.getSettings().setBuiltInZoomControls(true);
                        wvContent.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);;


                        wvContent.loadDataWithBaseURL(null, getHtmlContent(content), "text/html", "utf-8",null);
                        wvContent.setWebViewClient(new DetailWebViewClient());
                    }

                } catch (Exception e) {

                    Log.i("server_error", "eeeee");
                }


            }





            @Override
            public void onFailure(Call<WebViewBean> call, Throwable t) {
                Log.i("retrofit_error", t.getMessage());
            }
        });
    }

    public String getHtmlContent(String content) {
        String htmlContent =
                "<html><head><link rel=\"stylesheet\" href=\"file:///android_asset/webview/detail.css\" type=\"text/css\"/></head><body> \n" +
                        "<div class=\"main-wrap content-wrap\"> \n" +
                        "    <div class=\"content-inner\"> \n" +
                        "        <div class=\"question\"> \n" +
                        "            <div class=\"answer\"> \n" +
                        "                <div class=\"content\">" + content + "\n" +
                        "                </div> \n" +
                        "            </div> \n" +
                        "        </div> \n" +
                        "    </div> \n" +
                        "</div></body> \n"+
                        "\n" +
                        "<script src=\"file:///android_asset/webview/echo.min.js\"></script>\n" +
                        "<script>\n" +
                        "\n" +
                        "    Echo.init({\n" +
                        "        offset: 0,\n" +
                        "        throttle: 0\n" +
                        "    });\n" +
                        "\n" +
                        "</script>\n" +

                        "</html>";

        htmlContent = htmlContent.replaceAll("<br />", "");
        return htmlContent;
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




    private class DetailWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_webview,menu);//设置右上角的填充菜单
//
//        return super.onCreateOptionsMenu(menu);
//
//
//    }


    class MyGestureListener implements GestureDetector.OnGestureListener {


        @Override
        public boolean onDown(MotionEvent e) {
            Log.i("onDown","entereonDown");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Toast.makeText(getApplicationContext(),"hello", Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.i("onSingleTapUp","entereonSingleTapUp");
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.i("onScroll","entereonScroll");
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.i("onLongPress","entereonLongPress");
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if (e1.getX() - e2.getX() > FLIP_DISTANCE) {
                Log.i("MYTAG", "向左滑...");
                return true;
            }
            if (e2.getX() - e1.getX() > FLIP_DISTANCE) {
                Log.i("MYTAG", "向右滑...");
                return true;
            }
            if (e1.getY() - e2.getY() > FLIP_DISTANCE) {
                Log.i("MYTAG", "向上滑...");
                return true;
            }
            if (e2.getY() - e1.getY() > FLIP_DISTANCE) {
                Log.i("MYTAG", "向下滑...");
                return true;
            }

            Log.d("TAG", e2.getX() + " " + e2.getY());

            return false;
        }


    }



}
