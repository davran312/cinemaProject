package com.example.virus.cinemalineproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.virus.cinemalineproject.apies.MovieApi;
import com.example.virus.cinemalineproject.movie_model.MovieFeed;
import com.example.virus.cinemalineproject.movie_model.children.Movie;
import com.example.virus.cinemalineproject.movie_model.children.children.Session;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieListActivity extends Activity{
    GridView gridView ;
    public  List<Movie> movieList;
    int currentPosition = 0;
    private String actionBarTitle = "";
    private  static ArrayList<Session> sessions;
    MovieAdapter movieAdapter;

    public static ArrayList<Session> getSession() {
        return sessions;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setGridViewConfiguration();
        initializeMovieJsonFile();
        setActionBarSettings();


    }

    private void createIntentForNextActivity(int position) {
        Intent intent = new Intent(MovieListActivity.this, MovieDetailActivity.class);
        intent.putExtra("movie", movieList.get(position));
        intent.putExtra("title",actionBarTitle);
        startActivity(intent);

    }

    private void setGridViewConfiguration() {
        gridView = findViewById(R.id.gw_movie);
        gridView.setClickable(true);
        gridView.setNumColumns(3);
        gridView.setClickable(true);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sessions = (ArrayList<Session>) movieList.get(position).getSessionArrayList();
                createIntentForNextActivity(position);
            }

        });

    }

    private void setActionBarSettings() {
        getActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarTitle = getIntent().getExtras().getString("title");
        getActionBar().setTitle(actionBarTitle);
    }


    private void initializeMovieJsonFile() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(MovieApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        final MovieApi movieApi = retrofit.create(MovieApi.class);
        Call<MovieFeed> call = movieApi.getMovies();

        call.enqueue(new Callback<MovieFeed>() {
            @Override
            public void onResponse(Call<MovieFeed> call, Response<MovieFeed> response) {
                 movieList = response.body().getMovieList();
                 movieAdapter = new MovieAdapter(getApplicationContext(),R.layout.listview_movie,movieList);
                gridView.setAdapter(movieAdapter);

            }

            @Override
            public void onFailure(Call<MovieFeed> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT);
            }
        });
    }

    private void fillListViewMovie(View convertView,int position) {
        TextView title;
        ImageView filmIcon;
        title = convertView.findViewById(R.id.movie_name);
        filmIcon = convertView.findViewById(R.id.movie_icon);
        title.setText(movieList.get(position).getName());
        String imageUrl = Tools.changeImageUrlToBiggerSize("https://kinoafisha.ua/"+movieList.get(position).getImage());
        Picasso.get().load(imageUrl).into(filmIcon);

    }



    private class MovieAdapter extends ArrayAdapter {
        int resource;
        private LayoutInflater inflater;
        public MovieAdapter( Context context, int resource, List objects) {
            super(context, resource, objects);
            movieList = objects;
            this.resource = resource;
            inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView == null){
                convertView = inflater.inflate(resource,null);
            }
            fillListViewMovie(convertView,position);

            return convertView;
        }

    }

}
