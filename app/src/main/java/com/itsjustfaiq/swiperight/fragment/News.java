package com.itsjustfaiq.swiperight.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itsjustfaiq.swiperight.R;
import com.itsjustfaiq.swiperight.adapter.ArticleListAdapter;
import com.itsjustfaiq.swiperight.model.Article;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * A simple {@link Fragment} subclass.
 */
public class News extends Fragment {

    ArrayList<Article> articles = new ArrayList<>();
    RecyclerView recyclerView;

    ArticleListAdapter articleListAdapter;

    public News() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_news, container, false);

        for (int i = 0; i < 10; i++) {
            articles.add(new Article(
                    "21769",
                    "python-software-foundation-terima-hibah-170000-dari-mozilla-open-source-program-5a275ad53f531",
                    "Python Software Foundation Terima Hibah $170.000 dari Mozilla Open Source Program",
                    "Lord Voldemort",
                    "https://www.gravatar.com/avatar/6a7d1f244946a619883181f5b6f0cddd?s=100",
                    "Beberapa waktu yang lalu, Python Software Foundation (PSF) menerima hibah $170.000 dari Mozilla Open Source Program. Hibah ini diberikan oleh..",
                    "06 Dec 2017",
                    "http://www.codepolitan.com/python-software-foundation-terima-hibah-170000-dari-mozilla-open-source-program-5a275ad53f531",
                    "https://static.cdn-cdpl.com/270x135/998b78e349061b4971c0a2b0e8d6be41/header-python-logo-flat-image700x350-crop-image700x350-crop-1-image(700x350-crop)-image(700x350-crop).png",
                    ""));
        }

        recyclerView = v.findViewById(R.id.rvNews);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        articleListAdapter = new ArticleListAdapter(articles,getContext());
        recyclerView.setAdapter(articleListAdapter);

        readContent();

        return v;

    }

    public void readContent(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://759b74ce43947f5f4c91aeddc3e5bad3d.codepolitan.com/api/v2/posts/category/news", new AsyncHttpResponseHandler(){

            @Override
            public void onStart() {
                Log.d("NewsFragment", "onStart: proses pembacaan API dimulai");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d("NewsFragment", "onSuccess: pembacaan data API berhasil");

                try {
                    String content = new String(responseBody);
                    Log.d("SUCCES_RESP", ""+content);
                    JSONObject object = new JSONObject(content);
                    JSONArray result = object.getJSONArray("result");
                    articles.clear();
                    for(int i=0;i<result.length();i++)
                    {
                        JSONObject objectArticleJSON = result.getJSONObject(i);
                        String id = objectArticleJSON.getString("id");
                        String slug = objectArticleJSON.getString("slug");
                        String title = objectArticleJSON.getString("title");
                        String authorName = objectArticleJSON.getString("author_name");
                        String authorImage = objectArticleJSON.getString("author_image");
                        String description = objectArticleJSON.getString("description");
                        String date = objectArticleJSON.getString("date");
                        String link = objectArticleJSON.getString("link");
                        String thumbnail = objectArticleJSON.getString("thumbnail");
                        String total_views = objectArticleJSON.getString("total_views");
                        Article article = new Article(id,slug,title,authorName,authorImage,description,date,link,thumbnail,total_views);
                        articles.add(article);
                    }
                    articleListAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("NewsFragment", "onFailure: pembacaan data gagal dengan kode " + statusCode);
            }

            @Override
            public void onRetry(int retryNo) {
                Log.d("NewsFragment", "onRetry: melakukan pembacaan ulang API");
            }
        });
    }
}
