package com.marat.hvatit.tupit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import adapter.RecycleAdapter;

import com.marat.hvatit.tupit.model.FilmCollectionStore;

public class MainActivity extends AppCompatActivity {
    RecycleAdapter adapter;
    GridView gridView;
    ImageButton gridButton;
    ArrayAdapter<String> adapterGrid;
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.listoffilms);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        //Создание коллекции
        FilmCollectionStore store = new FilmCollectionStore();
        // настроить RecyclerView
        recyclerView.setLayoutManager(linearLayoutManager);
        //Получение коллекции и её данных в адаптере
        adapter = new RecycleAdapter(this, store.getCollection());
        recyclerView.setAdapter(adapter);
        gridButton = (ImageButton) findViewById(R.id.imagegrid);
        gridButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(recyclerView.getLayoutManager()==linearLayoutManager) {
                    recyclerView.setLayoutManager(gridLayoutManager);
                    recyclerView.setAdapter(adapter);
                }
                else{
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);
                }
            }
        });
    }

}