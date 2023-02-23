package com.example.newsdekho;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopHeadlinesFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopHeadlinesFragment extends Fragment {
    private RecyclerView recyclerViewHeadlines;
    private ArrayList<News> newsList = new ArrayList<>();
    private   RecyclerViewAdapter recyclerViewAdapter;
    private static final String apiKey = "ffbea0b4d2be4ad4b149cab9613d9aa1";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_top_headlines,container,false);

        recyclerViewHeadlines = view.findViewById(R.id.recyclerViewHeadlines);
        recyclerViewHeadlines.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerViewHeadlines.setHasFixedSize(true);

        FetchNewsData();

        return view;
    }
    public void FetchNewsData(){

        final myApiInterface apiService = ApiClient.getClient().create(myApiInterface.class);
        Call<ResponseModel> call = apiService.getLatestNews("in",apiKey);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, retrofit2.Response<ResponseModel> response) {
                if(response.body().getStatus().equals("ok")) {
                    List<News> articleList = response.body().getArticles();
                    if(articleList.size()>0) {
                        for (int i = 0; i < articleList.size() ; i++) {
                            Log.d( "onResponse",articleList.get(i).getTitle());

                            News news = new News();
                            String author = articleList.get(i).getAuthor();
                            String title = articleList.get(i).getTitle();
                            String imageUrl = articleList.get(i).geturlToImage();
                            String url = articleList.get(i).getUrl();
                            String publishedAt = articleList.get(i).getPublishedAt();
                            news.setAuthor(author);
                            news.setTitle(title);
                            news.setImageUrl(imageUrl);
                            news.setUrl(url);
                            news.setPublishedAt(publishedAt);
                            newsList.add(news);
                        }
                        recyclerViewAdapter = new RecyclerViewAdapter(getContext(),newsList);
                        recyclerViewHeadlines.setAdapter(recyclerViewAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.e("out", t.toString());
            }
        });

    }
}