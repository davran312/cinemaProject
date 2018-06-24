package com.example.virus.cinemalineproject;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.virus.cinemalineproject.movie_model.children.Movie;
import com.example.virus.cinemalineproject.movie_model.children.children.Session;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends Activity {
    private Movie movie = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);
        setActionBarSetting();

         movie = getIntent().getExtras().getParcelable("movie");

        initializeFields(movie);
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount()==0)
            this.finish();

        else
            getFragmentManager().popBackStack();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_seans:
                showSeansForCurrentMovie();
                break;
            default: return  super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSeansForCurrentMovie() {
        TimeListFragment fragment = new TimeListFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private ArrayList<String> getSeansTimes(List<Session> sessionArrayList) {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i <sessionArrayList.size() ; i++) {
            temp.add(sessionArrayList.get(i).getSessions());
        }
        return temp;

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem menuItem = menu.findItem(R.id.action_seans);

        return super.onCreateOptionsMenu(menu);
    }
    private void setActionBarSetting() {
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle(getIntent().getStringExtra("title"));
    }

    private void initializeFields(Movie movie) {
        TextView country;
        TextView rating;
        TextView age;
        TextView actors;
        TextView rejissers;
        TextView premier;
        RatingBar ratingStar;
        TextView votesCount;
        TextView title;
        ImageView filmIcon;
        RatingBar ratingBar;


        rating = findViewById(R.id.rating);
        country = findViewById(R.id.country);
        age = findViewById(R.id.age);
        actors = findViewById(R.id.actors);
        rejissers =findViewById(R.id.rejissers);
        premier = findViewById(R.id.date);
        ratingStar = findViewById(R.id.rating_star);
        votesCount = findViewById(R.id.votes);
        ratingStar.setNumStars(1);
        title = findViewById(R.id.name);
        filmIcon = findViewById(R.id.poster);
        ratingBar = findViewById(R.id.rating_bar);

        String imageUrl = Tools.changeImageUrlToBiggestSize("https://kinoafisha.ua/"+movie.getImage());

        String act = Tools.getNames(movie.getActors());
        String rejs =Tools.getNames(movie.getRejissers());

        Picasso.get().load(imageUrl).into(filmIcon);

        ratingBar.setDrawingCacheBackgroundColor(getResources().getColor(R.color.lime));
        title.setText(movie.getName());
        rating.setText(movie.getVote());
        country.setText(getResources().getString(R.string.country)+" : "+movie.getCountries());
        age.setText(getResources().getString(R.string.age)+" : "+movie.getAge_limit());
        actors.setText(getResources().getString(R.string.actors)+" : "+act);
        rejissers.setText(getResources().getString(R.string.rejissers)+" : "+rejs);
        premier.setText(getResources().getString(R.string.premier)+" : "+movie.getPremier_ua());
        ratingBar.setRating(
                movie.getVote().length()>1?(
                (Float.valueOf(movie.getVote().charAt(0)+"."+movie.getVote().charAt(2)))/2.0f)
                        :Float.valueOf(movie.getVote()));
        votesCount.setText(getResources().getString(R.string.votes_count)+" : "+movie.getCount_vote());


    }

}
