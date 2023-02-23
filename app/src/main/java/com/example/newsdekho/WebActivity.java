package com.example.newsdekho;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;


public class WebActivity extends AppCompatActivity {
 private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = findViewById(R.id.webView);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Log.d("webUrl", url);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

    }
}