package com.example.firststepv01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WorkPage extends AppCompatActivity {

    private RewardedAd rewardedAd;
    private static final String BASE_URL = "http://192.168.1.3/LoginAndRegister/GetAllAds.php";
    TextView username;
    Button bonusReward,withdraw, work, editBtn;
    RecyclerView adsListView;
    ProgressBar progressBar;
    private List<Ad> ads;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        progressBar = findViewById(R.id.progressBar);
        username = findViewById(R.id.username);
        bonusReward = findViewById(R.id.bonusReward);
        work = findViewById(R.id.work_btn);
        work.setText("Logs");
        withdraw = findViewById(R.id.withdraw_btn);
        editBtn = findViewById(R.id.edit_btn);
        adsListView = findViewById(R.id.adsList);
        adsListView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        adsListView.setHasFixedSize(true);
        ads = new ArrayList<>();

////        Ad ad = new Ad("test","https://deadline.com/wp-content/uploads/2018/02/tv-ads-advertising.jpg?crop=0px%2C1006px%2C5000px%2C2803px&resize=681%2C383",10);
////        Ad ad1 = new Ad("test","https://deadline.com/wp-content/uploads/2018/02/tv-ads-advertising.jpg?crop=0px%2C1006px%2C5000px%2C2803px&resize=681%2C383",10);
////        ads.add(ad);
////        ads.add(ad1);
//        AdAdapter adapter = new AdAdapter(getApplicationContext(), ads);
//        adsListView.setAdapter(adapter);
        getAds();
        rewardedAd = new RewardedAd(this,
                "ca-app-pub-3940256099942544/5224354917");

        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.
            }

            @Override
            public void onRewardedAdFailedToLoad(LoadAdError adError) {
                // Ad failed to load.
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);


        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EditProfile.class);
                startActivity(i);
            }
        });

        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LogsPage.class);
                startActivity(intent);
            }
        });

        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditProfile.class);
                startActivity(intent);
            }
        });

        withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Withdraw.class);
                startActivity(i);
            }
        });

        bonusReward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rewardedAd.isLoaded()) {
                    AppCompatActivity activityContext = WorkPage.this;
                    RewardedAdCallback adCallback = new RewardedAdCallback() {
                        @Override
                        public void onRewardedAdOpened() {
                            // Ad opened.
                        }

                        @Override
                        public void onRewardedAdClosed() {
                            // Ad closed.
                        }

                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem reward) {
                            // User earned reward.
                        }

                        @Override
                        public void onRewardedAdFailedToShow(AdError adError) {
                            // Ad failed to display.
                        }
                    };
                    rewardedAd.show(activityContext, adCallback);
                } else {
                    Toast.makeText(getApplicationContext() , "The rewarded ad wasn't loaded yet.", Toast.LENGTH_SHORT).show();
                }

            }

        });



    }

    private void getAds (){

        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressBar.setVisibility(View.GONE);

                        try {
                            JSONArray array = new JSONArray(response);

                            for (int i =0; i<array.length(); i++){
                                JSONObject object = array.getJSONObject(i);

                                int price = object.getInt("price");
                                String title = object.getString("title");
                                String photo = object.getString("photo");


                                Ad ad = new Ad(title, photo, price);
                                ads.add(ad);
                            }
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
                        }

                        AdAdapter adapter = new AdAdapter(getApplicationContext(),ads);
                        adsListView.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });


        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);

    }



    public RewardedAd createAndLoadRewardedAd() {
        RewardedAd rewardedAd = new RewardedAd(this,
                "ca-app-pub-3940256099942544/5224354917");
        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // onRewarded
            }

            @Override
            public void onRewardedAdFailedToLoad(LoadAdError adError) {
                onRewardedAdClosed();
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
        return rewardedAd;
    }

    public void onRewardedAdClosed() {
        this.rewardedAd = createAndLoadRewardedAd();
    }
}