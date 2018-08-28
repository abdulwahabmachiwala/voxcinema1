package com.wahab.vox.cinema.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wahab.vox.cinema.MovieDetailsActivity;
import com.wahab.vox.cinema.R;
import com.wahab.vox.cinema.models.Movie;

import java.util.ArrayList;


/**
 * Created by Nishat Sayyed on 16-08-2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    public static final String KEY_MOVIE = "KEY_MOVIE";

    private ArrayList<Movie> movies;
    private Context context;

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_lsit_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{

        private ImageView thumbnailView;
        private ImageView trailerImageView;
        private TextView nameTextView;
        private Button languageButton;
        private Button durationButton;

        MovieViewHolder(View itemView) {
            super(itemView);
            thumbnailView = (ImageView) itemView.findViewById(R.id.imb1);
            durationButton = (Button) itemView.findViewById(R.id.button15);
            languageButton = (Button) itemView.findViewById(R.id.button);
            nameTextView = (TextView) itemView.findViewById(R.id.textView);
            trailerImageView = (ImageView) itemView.findViewById(R.id.imageButton2);
        }

        void bind(Movie movie) {
            thumbnailView.setBackgroundResource(movie.getThumbnail());
            nameTextView.setText(movie.getName());
            languageButton.setText(movie.getLanguage());
            durationButton.setText(movie.getDuration());

            setListeners(movie);
        }

        void setListeners(final Movie movie) {
            trailerImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri webpage = Uri.parse(movie.getTrailerUrl());
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                    context.startActivity(webIntent);
                }
            });

            thumbnailView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, MovieDetailsActivity.class);
                    intent.putExtra(KEY_MOVIE, movie);
                    context.startActivity(intent);
                }
            });
        }
    }
}
