package com.example.guest.moviesapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guest.moviesapp.Constants;
import com.example.guest.moviesapp.Model.Movie;
import com.example.guest.moviesapp.R;
import com.example.guest.moviesapp.UI.MainActivity;
import com.example.guest.moviesapp.UI.MovieDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 12/1/16.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private ArrayList<Movie> mMovies = new ArrayList<>();
    private Context mContext;

    public MovieListAdapter(Context context, ArrayList<Movie> movies) {
        mContext = context;
        mMovies = movies;
    }

    @Override
    public MovieListAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.MovieViewHolder holder, int position) {
        holder.bindMovie(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.movieIdTextView) TextView mMovieIdView;
        @Bind(R.id.movieImageView) ImageView mMovieImageView;
        @Bind(R.id.movieTitleTextView) TextView mMovieTitleTextView;
        @Bind(R.id.dateTextView) TextView mDateTextView;
        @Bind(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindMovie(Movie movie) {
            Picasso.with(mContext).load(Constants.POSTER_BASE_URL + movie.getPosterUrl()).into(mMovieImageView);
            mMovieTitleTextView.setText(movie.getTitle());
            mDateTextView.setText(movie.getReleaseDate());
            mRatingTextView.setText("Rating: " + Double.toString(movie.getRating()) + "/10");
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, MovieDetailActivity.class);
            String clickedMovieId = mMovies.get(getLayoutPosition()).getMovieId();
            intent.putExtra("movieId", clickedMovieId);
            Log.d("movieId", clickedMovieId);
            mContext.startActivity(intent);
        }
    }

}
