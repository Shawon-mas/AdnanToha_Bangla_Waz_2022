package com.abuadnanwaz2022.abuadnantohawaz2022.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.abuadnanwaz2022.abuadnantohawaz2022.R;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.card.MaterialCardView;

import es.dmoral.toasty.Toasty;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    MaterialCardView materialCardView1,materialCardView2,materialCardView3,materialCardView4;
    AdView adView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url=getString(R.string.life_web_link);
        intViews();
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        addShow();
        interestialAds();

    }

    private void interestialAds() {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        if (mInterstitialAd != null) {
                            mInterstitialAd.show(MainActivity.this);
                        } else {
                            Log.d("TAG", "The interstitial ad wasn't ready yet.");
                        }

                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                            @Override
                            public void onAdDismissedFullScreenContent() {

                                Toasty.warning(getApplicationContext(),"Cancel Button Click", Toasty.LENGTH_LONG).show();
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when fullscreen content failed to show.
                                Log.d("TAG", "The ad failed to show.");
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Called when fullscreen content is shown.
                                // Make sure to set your reference to null so you don't
                                // show it a second time.
                                mInterstitialAd = null;
                                Log.d("TAG", "The ad was shown.");
                            }
                        });

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                        Log.i(TAG, loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });
    }

    private void addShow() {
        adView = findViewById(R.id.adView_main);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

    private void intViews() {
        String url=getString(R.string.life_web_link);
        materialCardView1=findViewById(R.id.home_card_1);
        materialCardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interestialAds();
                Intent intent =new Intent(getApplicationContext(),LifeStoryLoad.class);
                intent.putExtra("Link",url);
                startActivity(intent);
            }
        });
        materialCardView2=findViewById(R.id.home_card_2);
        materialCardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interestialAds();
                Intent intent =new Intent(getApplicationContext(),WazActivity.class);
                startActivity(intent);
            }
        });
        materialCardView3=findViewById(R.id.card3);
        materialCardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interestialAds();
                Intent intent =new Intent(getApplicationContext(),LifeActivity.class);
                startActivity(intent);
            }
        });
        materialCardView4=findViewById(R.id.card4);
        materialCardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interestialAds();
                Intent intent =new Intent(getApplicationContext(),IslamLife.class);
                startActivity(intent);
            }
        });
    }
}