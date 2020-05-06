package com.ldstemplevirtualization;


import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {

    private WebView homePage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);

        homePage = findViewById(R.id.myWebView);
        homePage.loadUrl("https://www.churchofjesuschrist.org/?lang=eng");
        homePage.setWebViewClient(new WebViewClient());

        ((ViewGroup)homePage.getParent()).removeView(homePage);
        setContentView(homePage);



    }
}
