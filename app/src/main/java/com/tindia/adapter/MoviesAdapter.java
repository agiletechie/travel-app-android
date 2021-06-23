package com.tindia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tindia.R;
import com.tindia.model.Movie;

import java.util.List;

/**
 * Created by sontbv on 3/7/18.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<Movie> movies;
    private Context context;

    public MoviesAdapter(Context context, List<Movie> movies) {
        this.movies = movies;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, director, description;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            director = (TextView) itemView.findViewById(R.id.director);
            description = (TextView) itemView.findViewById(R.id.description);
        }
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.title.setText(movie.getTitle());
        holder.director.setText(movie.getDirector());
        holder.description.setText(movie.getDescription());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}