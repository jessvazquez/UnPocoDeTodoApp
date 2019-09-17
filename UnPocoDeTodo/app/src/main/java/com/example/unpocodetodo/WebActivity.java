package com.example.unpocodetodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class WebActivity extends AppCompatActivity {
    private WebView mWebView;
    Button btnAbrirWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        btnAbrirWeb = (Button) findViewById(R.id.btn_AbrirWeb);

        btnAbrirWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // INI AGREGADO
                mWebView = (WebView) findViewById(R.id.activity_main_webview);
                // Activamos jаvascript
                WebSettings webSettings = mWebView.getSettings();
                // Url que carga la app (webview)
                mWebView.loadUrl("https://google.com/");
                // Forzamos el webview para que abra los enlaces internos dentro de la la APP
                mWebView.setWebViewClient(new WebViewClient());
                // Forzamos el webview para que abra los enlaces externos en el navegador
                mWebView.setWebViewClient(new MyAppWebViewClient());
            }
        });

    }
}
