package com.wisc.xss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * This file receives the user input IPv4 from MainActivity.java
 * and concat with other string literals to complete the URL; then
 * uses WebView component to open the URL.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create a webview object
        WebView web;
        web = (WebView)findViewById(R.id.web1);
        web.getSettings().setJavaScriptEnabled(true);
        //by default, alert() does not respond in webview; so manually open JsAlert()
        web.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message,
                                     JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
        //force the web page to present in app instead of a browser
        web.setWebViewClient(new WebViewClient());

        //concat IPv4 to complete the desired URL
        web.loadUrl("http://10.0.2.2:8080");
    }
}

