package com.chamiapps.dev.sltube.Fragmnets;


import android.content.ClipData;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chamiapps.dev.sltube.Models.repon.ItemsItem;
import com.chamiapps.dev.sltube.Models.repon.Snippet;
import com.chamiapps.dev.sltube.R;
import com.chamiapps.dev.sltube.Services.API.Sync.Getyoutubevideosync;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChannelFragment extends Fragment implements Getyoutubevideosync.getVideosynccallback  {

    private RecyclerView recyclerView;
    Getyoutubevideosync  getyoutubevideosync;
    List<ItemsItem> itemListn;


    public ChannelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        loadJSON();
        return inflater.inflate(R.layout.fragment_channel, container, false);
    }

    private  void loadJSON(){

        getyoutubevideosync = new Getyoutubevideosync(getActivity(),itemListn,this);
        getyoutubevideosync.getRetrofit();

    }

    @Override
    public void onDataResponsefound(boolean status, List<Snippet> responce) {

    }

//    @Override
//    public void onVideolistfound(boolean status, List<Snippet> responce) {
//
//
//        String a =responce.get(0).getTitle().toString();
//
//        Toast.makeText(getActivity(),"name :"+a,Toast.LENGTH_LONG).show();
//
//
//    }


//
//    public void loadjson(){
//
//        getyoutubevideosync = new Getyoutubevideosync(getActivity(),itemListn,this);
//
//
//    }

}
