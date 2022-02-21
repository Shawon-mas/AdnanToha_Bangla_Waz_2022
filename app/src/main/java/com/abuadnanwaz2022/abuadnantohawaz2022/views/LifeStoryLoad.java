package com.abuadnanwaz2022.abuadnantohawaz2022.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.abuadnanwaz2022.abuadnantohawaz2022.R;

public class LifeStoryLoad extends AppCompatActivity {
    WebView webView_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_story_load);
        webView_load=findViewById(R.id.webview);
        webView_load.loadUrl(getIntent().getStringExtra("Link"));
        WebSettings webSettings = webView_load.getSettings();
        webSettings.setJavaScriptEnabled(true);
        WebViewClient viewClient=new WebViewClient();
        webView_load.setWebViewClient(viewClient);
    }
}