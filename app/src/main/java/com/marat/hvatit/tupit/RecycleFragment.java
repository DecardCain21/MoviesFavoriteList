package com.marat.hvatit.tupit;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.marat.hvatit.tupit.model.FilmCollectionStore;
import com.marat.hvatit.tupit.model.Objfilm;
import com.marat.hvatit.tupit.model.interfaces.IcreateFragment;
import com.marat.hvatit.tupit.model.interfaces.RowType;

import adapter.RecycleAdapter;


public class RecycleFragment extends Fragment {
    FilmCollectionStore store = FilmCollectionStore.getInstance();
    RecycleAdapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycle, container, false);
        recyclerView = view.findViewById(R.id.vrecyclefragment);
        adapter = new RecycleAdapter(getContext(), new RecycleAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Objfilm objfilm) {
                //Ставим костыль ВОТ СЮДА,чтобы при возвращении не увидеть изврат
                if(objfilm.getFilmType()== RowType.GRID_ROW_TYPE) {
                    store.setUngrid();
                }
                Activity activity = requireActivity();
                try {
                    ((IcreateFragment) activity).someFragment(objfilm);
                } catch (Exception e) {
                    Log.e("Tag", "ERROR");
                }

            }
        });
        adapter.update(store.getCollection());
        linearLayoutManager = new LinearLayoutManager(getContext());
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        ImageButton gridButton = (ImageButton) getActivity().findViewById(R.id.imagegrid);
        gridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (recyclerView.getLayoutManager() == linearLayoutManager) {
                    store.setGrid();
                    recyclerView.setLayoutManager(gridLayoutManager);
                } else {
                    store.setUngrid();
                    recyclerView.setLayoutManager(linearLayoutManager);
                }
               adapter.update(store.getCollection());
            }
        });
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }
}