package me.entere.myapp.webview;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by entere on 17/6/23.
 */

public interface WebViewApi {

    @GET("api/p/{aid}")
    Call<WebViewBean> getData(@Path("aid") long aid);
}
