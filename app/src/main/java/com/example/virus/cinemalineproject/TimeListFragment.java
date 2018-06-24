package com.example.virus.cinemalineproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.virus.cinemalineproject.movie_model.children.Movie;
import com.example.virus.cinemalineproject.movie_model.children.children.Session;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TimeListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.seans_list_fragment,null);

        setFragmentFront(view);
        return view;
    }

    private void setFragmentFront(View view) {
        ArrayList<Session> sessionArrayList = MovieListActivity.getSession();
        String halls =getHalls(sessionArrayList);
        String times =getTimes(sessionArrayList);
        String hallColumn ="";
        String timeColumn ="";
        String[] hallArray = halls.split(",");
        String[] timesArray = times.split(",");
        TextView hallListView = view.findViewById(R.id.hall_names_tv);
        TextView timeListView = view.findViewById(R.id.times_tv);

        for (int i = 0; i <hallArray.length ; i++) {
            hallColumn+=hallArray[i]+"\n";
            timeColumn+=timesArray[i]+"\n";
        }
        hallColumn+="\n                    ";
        hallListView.setText(hallColumn);
        timeListView.setText(timeColumn);

    }

    private String getTimes(ArrayList<Session> sessionArrayList) {
        String times = "";
        for (int i = 0; i < sessionArrayList.size(); i++) {
            String temp = sessionArrayList.get(i).getSessions();
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '>' && Character.isDigit(temp.charAt(j+1<temp.length()-1?j+1:j))){
                    j++;
                    while (temp.charAt(j) != '<') {
                        times += temp.charAt(j);
                        if(j==temp.length()-1)
                            return times;
                        j++;
                    }
                    times += ",";
                }

            }
        }
        return times;


    }
        public String getHalls(ArrayList<Session> sessionArrayList) {
        String halls="";
        for (int i = 0; i <sessionArrayList.size(); i++) {
            halls+=sessionArrayList.get(i).getHallName()+",";
        }
        return halls;
    }
}



