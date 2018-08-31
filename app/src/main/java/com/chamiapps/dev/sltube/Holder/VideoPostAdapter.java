package com.chamiapps.dev.sltube.Holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chamiapps.dev.sltube.Models.repon.ItemsItem;
import com.chamiapps.dev.sltube.R;

import java.util.List;

/**
 * Created by fidenz on 3/27/18.
 */

public class VideoPostAdapter extends RecyclerView.Adapter<VideoPostAdapter.YoutubevideoHolder> {

    List<ItemsItem> itemList;
    private Context context;
    private Getpostion getpostioncallback;

    public VideoPostAdapter(List<ItemsItem> itemList, Context context, Getpostion getpostion) {
        this.itemList = itemList;
        this.context = context;
        this.getpostioncallback = getpostion;
    }

    @Override
    public YoutubevideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtube_postlayout, parent, false);
        return new YoutubevideoHolder(view);
    }

    @Override
    public void onBindViewHolder(YoutubevideoHolder holder, int position) {

        getpostioncallback.getpostion(position);

        holder.tvTitle.setText(itemList.get(position).getEtag());

    }

    @Override
    public int getItemCount() {

        return itemList.size();


}

    public class YoutubevideoHolder extends RecyclerView.ViewHolder {



        TextView tvTitle;
        TextView tvDescription;
        TextView tvDate;
        ImageView imgThumb;

        public YoutubevideoHolder(View itemView) {
            super(itemView);



            this.tvTitle = itemView.findViewById(R.id.tvtvvTitle);
            this.tvDescription = itemView.findViewById(R.id.tvdesc);
            this.tvDate = itemView.findViewById(R.id.tvdate);
            this.imgThumb = itemView.findViewById(R.id.imgviewthumb);
        }
    }

    public interface Getpostion{

        void getpostion(int position);

    }
}
