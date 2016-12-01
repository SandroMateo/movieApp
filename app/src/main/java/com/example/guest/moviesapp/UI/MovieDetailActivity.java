package com.example.guest.moviesapp.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guest.moviesapp.R;

import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        String movieId = intent.getStringExtra("location");


//        getMovieDetail(movieId);
    }
}
