package com.example.newsdekho;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Url;


public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{

    private RecyclerView recyclerView;
    private BottomNavigationView bottomNavigationView;
     private  ArrayList<News> newsList = new ArrayList<>();
   private   RecyclerViewAdapter recyclerViewAdapter;
   private static final String apiKey = "ffbea0b4d2be4ad4b149cab9613d9aa1";
    private FrameLayout frameLayout;


    private String headlinesUrl = "https://newsapi.org/v2/top-headlines?country=in&apiKey=ffbea0b4d2be4ad4b149cab9613d9aa1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frameLayout);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);



        bottomNavigationView.setOnItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new TopHeadlinesFragment()).commit();

//        NewsLoader newsLoader = new NewsLoader();

        //newsList = newsLoader.FetchNewsData()
     //   recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,newsList);
       // recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      Fragment selectedFragment = null ;
        if(item.getItemId()==R.id.itemHeadlines){
            selectedFragment = new TopHeadlinesFragment();
        }else  if(item.getItemId()==R.id.itemCategory){
            selectedFragment = new CategoriesFragment();

        }

        if (selectedFragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,selectedFragment).commit();
        }
        return false;
    }
}
