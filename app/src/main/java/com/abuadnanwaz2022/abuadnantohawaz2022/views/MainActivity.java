package com.abuadnanwaz2022.abuadnantohawaz2022.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.abuadnanwaz2022.abuadnantohawaz2022.R;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {
    MaterialCardView materialCardView1,materialCardView2,materialCardView3,materialCardView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url=getString(R.string.life_web_link);
        intViews();
    }

    private void intViews() {
        String url=getString(R.string.life_web_link);
        materialCardView1=findViewById(R.id.home_card_1);
        materialCardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),LifeStoryLoad.class);
                intent.putExtra("Link",url);
                startActivity(intent);
            }
        });
        materialCardView2=findViewById(R.id.home_card_2);
        materialCardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),WazActivity.class);
                startActivity(intent);
            }
        });
        materialCardView3=findViewById(R.id.card3);
        materialCardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),LifeActivity.class);
                startActivity(intent);
            }
        });
        materialCardView4=findViewById(R.id.card4);
        materialCardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),IslamLife.class);
                startActivity(intent);
            }
        });
    }
}