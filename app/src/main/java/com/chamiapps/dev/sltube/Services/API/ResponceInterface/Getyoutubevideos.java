package com.chamiapps.dev.sltube.Services.API.ResponceInterface;

import com.chamiapps.dev.sltube.Models.repon.DataResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by fidenz on 3/27/18.
 */

public interface Getyoutubevideos {


    @GET("/youtube/v3/search")
    Call<DataResponse> getVideos(@Query("key") String key,
                                 @Query("channelId") String channelid,
                                 @Query("part") String part,
                                 @Query("order") String order,
                                 @Query("maxResults") String maxresults);
}