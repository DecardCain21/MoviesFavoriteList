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
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;
    //Костыли................................
    private RecyclerView.Adapter savedState = null;
    private RecyclerView.LayoutManager savelayoutManager = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onButtonClick() {
        if (recyclerView.getLayoutManager() == linearLayoutManager) {
            savelayoutManager = new GridLayoutManager(getContext(), 2);
            savedState = filmGridAdapter;
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(filmGridAdapter);
        } else {
            savelayoutManager = new LinearLayoutManager(getContext());;
            savedState = filmListAdapter;
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(filmListAdapter);
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
        filmGridAdapter = new FilmGridAdapter(getContext(), store.getCollection(), new FilmListAdapter.ItemClickListener() {
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
        if (savedState != null&&savelayoutManager!=null) {
            recyclerView.setLayoutManager(savelayoutManager);
            recyclerView.setAdapter(savedState);
        }
        else {
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(filmListAdapter);
        }
        return view;
    }
}