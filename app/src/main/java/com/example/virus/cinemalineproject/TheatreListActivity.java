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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.virus.cinemalineproject.apies.TheatreApi;
import com.example.virus.cinemalineproject.theatre_model.TheatreFeed;
import com.example.virus.cinemalineproject.theatre_model.children.Theatre;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TheatreListActivity extends Activity {
    private List<Theatre> theatreList;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theatre_list);
        listView = findViewById(R.id.lw_theatres);
        initializeTheatreJsonFile();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(TheatreListActivity.this, MovieListActivity.class);
                intent.putExtra("title",theatreList.get(position).getName());
                startActivity(intent);
            }
        });


    }

    private void initializeTheatreJsonFile() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(TheatreApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        final TheatreApi theatreApi = retrofit.create(TheatreApi.class);
        Call<TheatreFeed> feedCall = theatreApi.getTheatres();
        feedCall.enqueue(new Callback<TheatreFeed>() {
            @Override
            public void onResponse(Call<TheatreFeed> call, Response<TheatreFeed> response) {
                theatreList = response.body().getResult().getTheatres();
                TheatreAdapter adapter = new TheatreAdapter(getApplicationContext(),R.layout.listview_theatre,theatreList);
                listView.setAdapter(adapter);
             }

            @Override
            public void onFailure(Call<TheatreFeed> call, Throwable t) {

            }
        });
    }

    private class TheatreAdapter extends ArrayAdapter {
        
            int resource;
            private LayoutInflater inflater;
        public TheatreAdapter( Context context,int resource, List objects) {
                super(context, resource, objects);
                theatreList = objects;
                this.resource = resource;
                inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                if(convertView == null){
                    convertView = inflater.inflate(resource,null);
                }
                fillListViewTheatre(convertView,position);

                return convertView;
            }

        }

    private void fillListViewTheatre(View convertView, int position) {
        TextView name;
        ImageView image;
        TextView vote;
        TextView count_vote;
        TextView phoneNumber;
        TextView adress;

        count_vote = convertView.findViewById(R.id.theatre_vote);
        adress = convertView.findViewById(R.id.theatre_adress);
         name = convertView.findViewById(R.id.theatre_name);
         image = convertView.findViewById(R.id.theatre_icon);
         phoneNumber = convertView.findViewById(R.id.theatre_phone);

         count_vote.setText(theatreList.get(position).getCount_vote());
        Picasso.get().load("https://kinoafisha.ua/"+theatreList.get(position).getImage()).into(image);
         name.setText(theatreList.get(position).getName());
         adress.setText(getResources().getString(R.string.theatre_adress)+theatreList.get(position).getAddress());
        phoneNumber.setText(getResources().getString(R.string.thatre_phone)+theatreList.get(position).getPhoneNumber());

    }
}


