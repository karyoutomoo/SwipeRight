package com.itsjustfaiq.swiperight.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itsjustfaiq.swiperight.R;
import com.itsjustfaiq.swiperight.adapter.ArticleListAdapter;
import com.itsjustfaiq.swiperight.model.Article;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

        return v;

    }

}
