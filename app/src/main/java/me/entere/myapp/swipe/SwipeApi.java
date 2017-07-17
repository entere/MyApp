package me.entere.myapp.swipe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by entere on 17/6/20.
 */

public interface SwipeApi {
    //http://sr.blogchina.com/api/app?pid=31&card=no&first_time=0&last_time=0
    @GET("api/app")
    Call<SwipeBean> getData(@Query("pid") int pid, @Query("card") String card,@Query("first_time") long first_time, @Query("last_time") long last_time);
}
