package com.example.guest.moviesapp.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.guest.moviesapp.Model.Movie;
import com.example.guest.moviesapp.R;
import com.example.guest.moviesapp.Service.MovieService;
import com.example.guest.moviesapp.adapters.MovieListAdapter;

import org.parceler.Parcels;

import java.io.IOException;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        Movie mMovie = Parcels.unwrap(intent.getParcelableExtra("movie"));
        Log.d("movie", "movie: " + mMovie);


        getMovieDetail(mMovie);
    }

    private void getMovieDetail(Movie movie) {
        final MovieService movieService = new MovieService();
        final Movie thisMovie = movie;
        movieService.findMovieCredits(movie.getMovieId(), new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                movieService.processMovieCredits(thisMovie, response);
                Log.d("director", thisMovie.getDirector());
                MovieDetailActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                    }
                });

            }
        });
    }
}
