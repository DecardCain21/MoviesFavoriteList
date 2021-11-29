package com.marat.hvatit.tupit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;

import adapter.AnotherAdapter;
import adapter.FilmsAdapter;
import adapter.RecycleAdapter;

import com.marat.hvatit.tupit.model.Provider;
import com.marat.hvatit.tupit.model.Objfilm;

public class MainActivity extends AppCompatActivity {
    AnotherAdapter anotherAdapter;
    RecycleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Инициализация кастомного адаптера,контекст,массив данных который нужно внедрить в виджет
        //обычно второй параметр это указанние макета для раздутия,но он указан в кастомном адаптере
        //Adapter update
        //anotherAdapter = new AnotherAdapter(this,initFilms());
       /* ListView lvMain = (ListView) findViewById(R.id.listoffilms);
        lvMain.setAdapter(anotherAdapter);*/
        RecyclerView recyclerView = findViewById(R.id.listoffilms);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        // настроить RecyclerView
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecycleAdapter(this, initFilms());
        recyclerView.setAdapter(adapter);
    }


    public ArrayList<Objfilm> initFilms() {
        Provider somf = new Provider();
        return somf.generetefilm(10);
    }
}