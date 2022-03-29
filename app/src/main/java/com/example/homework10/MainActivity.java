package com.example.homework10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String refreshPage;


    WebView webBroaser;
    EditText addres;
    ImageButton search;
    WebPages webPages;
    TextView page_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webBroaser = findViewById(R.id.webBroaser);
        addres = findViewById(R.id.editTextTextPersonName);
        search = findViewById(R.id.button);

        webBroaser.setWebViewClient(new WebViewClient());
        webBroaser.getSettings().setLoadsImagesAutomatically(true);
        webBroaser.getSettings().setJavaScriptEnabled(true);
        webPages = WebPages.getSingleton();




        //Refresh button here
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webBroaser.loadUrl(refreshPage);
            }
        });

    }

// Search function here
    public void searchWeb(View view){
        webPages.listMaker();
        if(addres.getText().toString().equals("")){
            //Skip
        }

        else if(addres.getText().toString().equals("index.html")){
            String html = "file:///android_asset/" + addres.getText().toString();
            webPages.addWebPagesToList(html);
            //Last addres from addres list
            webBroaser.loadUrl(webPages.getUrlPages().get(webPages.getUrlPages().size()-1));
            this.refreshPage = webPages.getUrlPages().get(webPages.getUrlPages().size()-1);


        }
        else {
            String url = "http://" + addres.getText().toString();
            webPages.addWebPagesToList(url);
            //Last addres from addres list
            webBroaser.loadUrl(webPages.getUrlPages().get(webPages.getUrlPages().size()-1));
            this.refreshPage = webPages.getUrlPages().get(webPages.getUrlPages().size()-1);


        }
        addres.setText("");
    }
    public void frontButtont(View view){

        if(webPages.getIndex() <= 0){

        }
        else {
            webPages.setIndexFront(1);
            String newUrl = webPages.getUrlPages().get(webPages.getIndex()-1);
            webBroaser.loadUrl(newUrl);
            this.refreshPage = newUrl;

        }
    }

    public void backButton(View view){
        if(webPages.getIndex() <= 0){

        }
        else {
            webPages.setIndexBack(1);
            String newUrl = webPages.getUrlPages().get(webPages.getIndex() -1 );
            webBroaser.loadUrl(newUrl);
            this.refreshPage = newUrl;

            //this.refreshPage = newUrl;

        }

    }
    public void indexHTMLShout(View view){
        webBroaser.evaluateJavascript("javascript:shoutOut()", null);
    }
    public void indexHTMLInitialize(View view){
        webBroaser.evaluateJavascript("javascript:initialize()", null);
    }

}