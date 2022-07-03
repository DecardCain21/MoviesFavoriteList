package com.marat.hvatit.tupit;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marat.hvatit.tupit.model.FilmCollectionStore;
import com.marat.hvatit.tupit.model.Objfilm;
import com.marat.hvatit.tupit.model.interfaces.IcreateFragment;

import adapter.FilmGridAdapter;
import adapter.FilmListAdapter;


public class RecycleFragment extends Fragment {
    FilmCollectionStore store = FilmCollectionStore.getInstance();
    //Inicialize adapters...........
    FilmListAdapter filmListAdapter;
    FilmGridAdapter filmGridAdapter;
    //Create RecyclerView...........
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
    String manager_type = "linear";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            manager_type = savedInstanceState.getString("manager_type");
            switch (manager_type) {
                case "linear":
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(filmListAdapter);
                    break;
                case "grid":
                    recyclerView.setLayoutManager(gridLayoutManager);
                    recyclerView.setAdapter(filmGridAdapter);
            }
        } else {
            manager_type = "linear";
        }
    }

    public void onButtonClick() {
        if (recyclerView.getLayoutManager() == linearLayoutManager) {
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(filmGridAdapter);
            manager_type = "grid";
        } else {
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(filmListAdapter);
            manager_type = "linear";
        }


        filmListAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycle, container, false);
        recyclerView = view.findViewById(R.id.vrecyclefragment);
        linearLayoutManager = new LinearLayoutManager(getContext());
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        //Adapter`s..................................................
        filmListAdapter = new FilmListAdapter(getContext(), store.getCollection(), new FilmListAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Objfilm objfilm) {
                Activity activity = requireActivity();
                try {
                    ((IcreateFragment) activity).someFragment(objfilm);
                } catch (Exception e) {
                    Log.e("Tag", "ERROR of filmListAdapter");
                }

            }
        });
        filmGridAdapter = new FilmGridAdapter(getContext(), store.getCollection(), new FilmGridAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Objfilm objfilm) {
                Activity activity = requireActivity();
                try {
                    ((IcreateFragment) activity).someFragment(objfilm);
                } catch (Exception e) {
                    Log.e("Tag", "ERROR of filmGridAdapter");
                }
            }
        });
        //Базово стоит linearLayoutManager и FilmListAdapter

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(filmListAdapter);
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("manager_type", manager_type);
    }
}