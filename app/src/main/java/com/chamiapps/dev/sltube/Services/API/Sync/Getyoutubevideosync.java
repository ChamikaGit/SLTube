package com.chamiapps.dev.sltube.Services.API.Sync;

import android.content.ClipData;
import android.content.Context;
import android.widget.Toast;

import com.chamiapps.dev.sltube.Helpers.Consts;
import com.chamiapps.dev.sltube.Models.repon.DataResponse;
import com.chamiapps.dev.sltube.Models.repon.ItemsItem;
import com.chamiapps.dev.sltube.Models.repon.Snippet;
import com.chamiapps.dev.sltube.Services.API.ResponceInterface.Getyoutubevideos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fidenz on 3/27/18.
 */

public class Getyoutubevideosync {

    private Context context;
    private List<ItemsItem> itemListn = new ArrayList<>();
    private getVideosynccallback CALLBACK;

    public Snippet list;

    public Getyoutubevideosync(Context context, List<ItemsItem> itemListn, getVideosynccallback CALLBACK) {
        this.context = context;
        this.itemListn = itemListn;
        this.CALLBACK = CALLBACK;
    }

    public void getRetrofit(){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Consts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final Getyoutubevideos getyoutubevideosAPI = retrofit.create(Getyoutubevideos.class);
        Call<DataResponse> call = getyoutubevideosAPI.getVideos(Consts.API_KEY,Consts.CHANNEL_ID,Consts.PART,Consts.ORDER,Consts.MAXRESULTS);

        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {


                List<Snippet> temp = new ArrayList<>();
                if (response != null && response.isSuccessful() && response.body() != null) {

                    for (int i = 0; i < response.body().getItems().size(); i++) {
                        temp.add(response.body().getItems().get(i).getSnippet());

                    }
                    CALLBACK.onDataResponsefound(true, temp);

                } else {

                    CALLBACK.onDataResponsefound(false, null);
                    Toast.makeText(context,"Can't Connect to the API",Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });


    }

    public interface getVideosynccallback{


        void onDataResponsefound(boolean status, List<Snippet> responce);
    }
}
