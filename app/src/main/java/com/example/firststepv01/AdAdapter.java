package com.example.firststepv01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AdAdapter extends RecyclerView.Adapter<AdAdapter.MyViewHolder> {

    private Context mContext;
    private List<Ad> ads = new ArrayList<>();


    public AdAdapter (Context context,List<Ad> ads){
        this.mContext = context;
        this.ads = ads;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView adTitle, adPrice;
        private ImageView adImageView;


        public MyViewHolder (View view){
            super(view);

            adTitle = view.findViewById(R.id.adTitle);
            adImageView = view.findViewById(R.id.adImage);
            adPrice = view.findViewById(R.id.adPrice);

        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.ad_model,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Ad ad = ads.get(position);
        holder.adPrice.setText("Points: "+ad.getPrice());
        holder.adTitle.setText(ad.getTitle());
        try {
            Glide.with(mContext).load(ad.getImage()).into(holder.adImageView);
        } catch (Exception e) {
            Glide.with(mContext).load("https://images.squarespace-cdn.com/content/537a4829e4b0edb14eb0fd34/1400522942801-FH0H8KL9G9XL7TTLTRLL/Solo+Site+Logo.png?content-type=image%2Fpng").into(holder.adImageView);
        }
    }

    @Override
    public int getItemCount() {
        return ads.size();
    }
}