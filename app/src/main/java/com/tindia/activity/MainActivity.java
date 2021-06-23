package com.tindia.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tindia.R;
import com.tindia.adapter.DestinationsAdapter;
import com.tindia.adapter.MoviesAdapter;
import com.tindia.model.Destination;
import com.tindia.model.Movie;
import com.tindia.network.ApiInterface;
import com.tindia.network.ServiceGenerator;
import com.tindia.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movies = new ArrayList<>();
    private List<Destination> destinations = new ArrayList<>();
    private final String TAG = MainActivity.class.getSimpleName();
    private ProgressBar loader;
    private RecyclerView recyclerView;
    private MoviesAdapter moviesAdapter;
    private DestinationsAdapter destinationsAdapter;
    private TextView errorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loader = findViewById(R.id.progressBar);
        errorView = findViewById(R.id.errorView);


        recyclerView = findViewById(R.id.recyclerView);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        destinationsAdapter = new DestinationsAdapter(destinations, this);
        recyclerView.setAdapter(destinationsAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
//        recyclerView.setLayoutManager(linearLayoutManager);

//        moviesAdapter = new MoviesAdapter(MainActivity.this, movies);
//        recyclerView.setAdapter(moviesAdapter);


        getMovies();
    }


    public void handleItemClick(Destination destination){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(AppConstants.DEST_RESPONSE, destination);
        startActivity(intent);
    }

    private void getMovies() {
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
        Call<List<Movie>> call = apiInterface.getMovies();
        Call<List<Destination>> destination = apiInterface.getDestination();
        destination.enqueue(new Callback<List<Destination>>() {
            @Override
            public void onResponse(Call<List<Destination>> call, Response<List<Destination>> response) {
                //Log.d(TAG,);
                if (response.isSuccessful()) {
                    for (Destination destination : response.body()) {
                        destinations.add(destination);
                    }
                    //destinationsAdapter.notifyDataSetChanged();
                    destinationsAdapter.notifyDataSetChanged();
                } else {
                    Log.e(TAG, response.message());
                }
                loader.setVisibility(View.GONE);
                errorView.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<Destination>> call, Throwable t) {
                loader.setVisibility(View.GONE);
                errorView.setVisibility(View.VISIBLE);
                Log.e(TAG, t.getMessage());
            }
        });

//        call.enqueue(new Callback<List<Movie>>() {
//            @Override
//            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
//                if (response.isSuccessful()) {
//                    for (Movie movie : response.body()) {
//                        movies.add(movie);
//                    }
//                    moviesAdapter.notifyDataSetChanged();
//                } else {
//                    Log.e(TAG, response.message());
//                }
//                loader.setVisibility(View.GONE);
//                errorView.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onFailure(Call<List<Movie>> call, Throwable t) {
//                loader.setVisibility(View.GONE);
//                errorView.setVisibility(View.VISIBLE);
//                Log.e(TAG, t.getMessage());
//            }
//        });
    }
}