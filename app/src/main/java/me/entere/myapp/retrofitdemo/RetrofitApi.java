package me.entere.myapp.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by entere on 17/6/19.
 */

public interface RetrofitApi {
    //http://sr.blogchina.com/api/app?pid=3&card=no
    @GET("api/app")
    Call<RetrofitBean> getData(@Query("pid") int pid, @Query("card") String card);

}
