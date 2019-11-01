package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView wv_web = findViewById(R.id.wv_web);
        WebSettings webSettings = wv_web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv_web.addJavascriptInterface(new JavaScriptTest(),"android");
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        //wv_web.loadUrl("http://192.168.0.244:8000/android/index.html");
        //wv_web.loadUrl("https://www.naver.com");
        wv_web.loadUrl("file:///android_asset/index.html");
        wv_web.setWebViewClient(new WebViewClient());

    }
    class MyViewClient extends WebViewClient{
        //웹뷰 내에서 웹 페이지를 불러올때 사용함.
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            super.shouldOverrideUrlLoading(view,url);
            view.loadUrl(url);
            return true;
        }
    }
}
