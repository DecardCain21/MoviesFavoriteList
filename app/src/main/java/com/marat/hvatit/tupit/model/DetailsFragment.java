package com.marat.hvatit.tupit.model;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marat.hvatit.tupit.R;


public class DetailsFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        Objfilm objfilm = FilmCollectionStore.getInstance().getFilm(getArguments().getString("key"));
        Log.e("BunndleDetails:",getArguments().getString("key"));
        bindView(view, objfilm);
        return view;
    }

    public void bindView(final View view, final Objfilm objfilm) {
        TextView tVAnnotation = view.findViewById(R.id.short_descriptions_text);
        TextView textView = view.findViewById(R.id.director);
        TextView tVActer1 = view.findViewById(R.id.actor_1);
        TextView tVActer2 = view.findViewById(R.id.actor_2);
        TextView tVActer3 = view.findViewById(R.id.actor_3);
        TextView tVActer4 = view.findViewById(R.id.actor_4);
        tVActer1.setText(objfilm.getActers(0));
        tVActer2.setText(objfilm.getActers(1));
        tVActer3.setText(objfilm.getActers(2));
        tVActer4.setText(objfilm.getActers(3));
        tVAnnotation.setText(objfilm.getAnnotation());
        textView.setText(objfilm.getFilmId());
    }
}