package com.itsjustfaiq.swiperight.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itsjustfaiq.swiperight.DetailActivity;
import com.itsjustfaiq.swiperight.R;
import com.itsjustfaiq.swiperight.model.Article;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder> {

    ArrayList<Article> data;
    Context context;

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder articleViewHolder, int i) {
        final Article article = data.get(i);
        articleViewHolder.tvPenulis.setText(article.getAuthor_name());
        articleViewHolder.tvJudul.setText(article.getTitle());

        Picasso.with(context).load(article.getThumbnail()).into(articleViewHolder.ivThumbnail);

        articleViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToDetailActivity = new Intent(context, DetailActivity.class);
                goToDetailActivity.putExtra("article", article);
                context.startActivity(goToDetailActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public ArticleListAdapter(ArrayList<Article> data,Context context){
        this.context = context;
        this.data = data;
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder{
        TextView tvJudul, tvPenulis;
        ImageView ivThumbnail;

        public ArticleViewHolder(View itemView) {
            super(itemView);

            tvJudul = itemView.findViewById(R.id.tvJudul);
            tvPenulis = itemView.findViewById(R.id.tvPenulis);
            ivThumbnail = itemView.findViewById(R.id.ivSampul);
        }
    }
}
