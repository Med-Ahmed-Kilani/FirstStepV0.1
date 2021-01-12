package com.example.firststepv01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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


public class LogsPage extends AppCompatActivity {

    private RewardedAd rewardedAd;
    ListView lv;
    Button work, withdraw, bonusReward, editBtn;
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);

        bonusReward = findViewById(R.id.bonusReward);
        work = findViewById(R.id.work_btn);
        withdraw = findViewById(R.id.withdraw_btn);
        username = findViewById(R.id.username);
        editBtn = findViewById(R.id.edit_btn);
        lv = findViewById(R.id.logsList);

        ArrayList<Log> logs = new ArrayList<>();
        logs.add(new Log(1, "test", "test"));
        logs.add(new Log(2, "test1", "test1"));
        logs.add(new Log(3, "test2", "test2"));

        lv.setAdapter(new LogAdapter(getApplicationContext(), R.layout.log_model, logs));


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


        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WorkPage.class);
                startActivity(intent);
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
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
                    AppCompatActivity activityContext = LogsPage.this;
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