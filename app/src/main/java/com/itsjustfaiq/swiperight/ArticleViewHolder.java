package com.itsjustfaiq.swiperight;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleViewHolder {
    public class ArtikelViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul, tvPenulis;
        ImageView ivThumbnail;
        public ArtikelViewHolder(View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tvJudul);
            tvPenulis = itemView.findViewById(R.id.tvPenulis);
            ivThumbnail = itemView.findViewById(R.id.ivSampul);
        }
    }

}
