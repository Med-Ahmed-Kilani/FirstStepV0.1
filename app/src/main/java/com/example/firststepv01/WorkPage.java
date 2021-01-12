package com.example.firststepv01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.util.ArrayList;
import java.util.List;


public class WorkPage extends AppCompatActivity {

    private RewardedAd rewardedAd;

    TextView username;
    Button bonusReward,withdraw, work, editBtn;
    RecyclerView adsListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        username = findViewById(R.id.username);
        bonusReward = findViewById(R.id.bonusReward);
        work = findViewById(R.id.work_btn);
        work.setText("Logs");
        withdraw = findViewById(R.id.withdraw_btn);
        editBtn = findViewById(R.id.edit_btn);
        adsListView = findViewById(R.id.adsList);
        adsListView.setLayoutManager(new LinearLayoutManager(this));
        adsListView.setHasFixedSize(true);

        List<Ad> ads = new ArrayList<>();
        Ad newAd = new Ad(5,"test", "goof", R.drawable.noimage, "0.01");
        Ad newAd2 = new Ad(5,"test", "goof", R.drawable.noimage, "0.01");

        ads.add(newAd);
        ads.add(newAd2);
        AdAdapter adapter = new AdAdapter(ads, getApplicationContext());

        adsListView.setAdapter(adapter);


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