package com.example.newsdekho;



import android.content.Context;
import android.content.Intent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<News> newsList;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView newsThumbnail;
        private TextView newsHeading , newsDate;
        private CardView cardView;
        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            //itemView.setOnClickListener(this);
            cardView = itemView.findViewById(R.id.cardView);
            newsThumbnail = itemView.findViewById(R.id.newsThumbnail);
            newsHeading =  itemView.findViewById(R.id.newsHeading);
            newsDate = itemView.findViewById(R.id.newsDate);

        }

        @Override
        public void onClick(View view) {

        }
    }

    public RecyclerViewAdapter(Context context, ArrayList<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    // where to get a single card as viewHolder ?
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_row,parent,false);

        return new ViewHolder(view);
    }

    // what will happen after getting ViewHolder object?

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      News currentNews = newsList.get(position);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,WebActivity.class);
                intent.putExtra("url",currentNews.getUrl());
                context.startActivity(intent);
            }
        });
        Log.d("UrlList", currentNews.getUrl());
        holder.newsHeading.setText(currentNews.getTitle());
        holder.newsDate.setText(currentNews.getPublishedAt());
        Glide.with(context).load(currentNews.geturlToImage()).into(holder.newsThumbnail);
      //  holder.newsThumbnail.setImageResource(Integer.parseInt(currentNews.getImageUrl()));
    }


    // how many items ?
    @Override
    public int getItemCount() {
        return newsList.size();
    }



}
