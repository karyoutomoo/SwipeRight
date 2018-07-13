package com.itsjustfaiq.swiperight;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.itsjustfaiq.swiperight.model.Article;

public class DetailActivity extends AppCompatActivity {

    private LinearLayout layoutProgress;
    private ProgressBar progressBar;
    private ProgressDialog progressDialog;
    Article article;
    private android.support.v7.app.ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        layoutProgress = (LinearLayout) findViewById(R.id.layoutprogress);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        article = getIntent().getParcelableExtra("article");

        actionBar = DetailActivity.this.getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        WebView webView = findViewById(R.id.browser);
        webView.loadUrl(article.getLink());

        getSupportActionBar().setTitle(article.getTitle());

        initDisplay();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                    DetailActivity.this.finish();
                    return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void displayProgressBar(){
        progressDialog = new ProgressDialog(DetailActivity.this);
        progressDialog.setMessage("Loading..");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }
    public void initDisplay(){
        displayProgressBar();

        WebView webView = (WebView) findViewById(R.id.browser);
        webView.setWebChromeClient(new WebChromeClient(){
            public void onProgressChanged(WebView view, int progress){
                try{
                    if (layoutProgress != null && progressBar != null){
                        layoutProgress.setVisibility(View.VISIBLE);
                        progressBar.setProgress(progress);

                        if(progress==100){
                            layoutProgress.setVisibility(View.GONE);
                            progressBar.setProgress(1);
                        }
                        else if(progress>40 && progress<100){
                            progressDialog.dismiss();
                        }else{
                            layoutProgress.setVisibility(View.VISIBLE);
                        }
                    }
                }
                catch (Exception e){
                    progressDialog.dismiss();
                    e.printStackTrace();
                }
            }
        });
        //type here
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(article.getLink());
    }
}
