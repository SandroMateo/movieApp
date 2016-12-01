package com.example.guest.moviesapp.Model;

import java.util.ArrayList;

/**
 * Created by Guest on 12/1/16.
 */
public class Movie {
    private String mTitle;
    private String mMovieId;
    private double mRating;
    private String mReleaseDate;
    private String mPosterUrl;
    private String mOverview;
    private String mDirector;
    private ArrayList<String> mMainActors = new ArrayList<>();

    public Movie(String title, String movieId, double rating, String releaseDate, String posterUrl) {
        this.mTitle = title;
        this.mMovieId = movieId;
        this.mRating = rating;
        this.mReleaseDate = releaseDate;
        this.mPosterUrl = posterUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getMovieId() {
        return mMovieId;
    }

    public double getRating() {
        return mRating;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getPosterUrl() {
        return mPosterUrl;
    }

    public String getOverview() {
        return mOverview;
    }

    public String getDirector() {
        return mDirector;
    }

    public ArrayList<String> getMainActors() {
        return mMainActors;
    }

    public void setOverview(String overview) {
        this.mOverview = overview;
    }

    public void setDirector(String director) {
        this.mDirector = director;
    }

    public void setMainActors(ArrayList<String> mainActors) {
        this.mMainActors = mainActors;
    }

}
