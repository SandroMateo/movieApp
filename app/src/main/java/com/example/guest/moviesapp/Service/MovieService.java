package com.example.guest.moviesapp.Service;

import android.util.Log;

import com.example.guest.moviesapp.Constants;
import com.example.guest.moviesapp.Model.Movie;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 12/1/16.
 */
public class MovieService {

    public static void findNowPlaying(Callback callback){
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL + Constants.PLAYING_QUERY_PARAMETERS).newBuilder();
        urlBuilder.addQueryParameter(Constants.API_QUERY_PARAMETER, Constants.API_KEY);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Movie> processNowPlayingResults(Response response) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()) {
                JSONObject movieJSON = new JSONObject(jsonData);
                JSONArray movieList = movieJSON.getJSONArray("results");
                for (int i = 0; i < movieList.length(); i++){
                    JSONObject movie = movieList.getJSONObject(i);
                    String title = movie.getString("title");
                    String movieId = Integer.toString(movie.getInt("id"));
                    double rating = movie.getDouble("vote_average");
                    String releaseDate = movie.getString("release_date");
                    String posterUrl = movie.getString("poster_path");

                    Movie newMovie = new Movie(title, movieId, rating, releaseDate, posterUrl);
                    movies.add(newMovie);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
