package com.example.firststepv01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdAdapter extends RecyclerView.Adapter<AdAdapter.ViewHolder>  {

    List<Ad> ads ;
    Context context;

    public AdAdapter(List<Ad> ads, Context context) {
        this.ads = ads;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ad_model, parent ,false);
        return new AdAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ad ad = ads.get(position);
        holder.adTitle.setText(ad.title);
    //    holder.adImage.setImageResource(ad.image);
        holder.adPrice.setText(ad.price);
        holder.adLink.setText(ad.link);

    }

    @Override
    public int getItemCount() {
        return ads.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView adTitle,adLink, adPrice;
        ImageView adImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            adTitle = itemView.findViewById(R.id.adTitle);
            adImage = itemView.findViewById(R.id.adImage);
            adLink = itemView.findViewById(R.id.adLink);
            adPrice = itemView.findViewById(R.id.adPrice);


        }
    }


}