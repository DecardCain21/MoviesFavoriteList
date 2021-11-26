package com.marat.hvatit.tupit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;

import adapter.AnotherAdapter;
import adapter.FilmsAdapter;

import com.marat.hvatit.tupit.model.Provider;
import com.marat.hvatit.tupit.model.Objfilm;

public class MainActivity extends AppCompatActivity {
    //private Toolbar toolbar;
    FilmsAdapter filmsAdapter;
    AnotherAdapter anotherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create toolbar
        //toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        //setSupportActionBar(toolbar);
        setSupportActionBar((Toolbar)findViewById(R.id.mytoolbar));
        //create Adapter
        initFilms();
        //Инициализация кастомного адаптера,контекст,массив данных который нужно внедрить в виджет
        //обычно второй параметр это указанние макета для раздутия,но он указан в кастомном адаптере
        filmsAdapter = new FilmsAdapter(this, initFilms());
        //Adapter update
        //anotherAdapter = new AnotherAdapter(this,initFilms());
        //config list
        ListView lvMain = (ListView) findViewById(R.id.listoffilms);
        lvMain.setAdapter(filmsAdapter);
        //вариант короткой записи,для одноразового теста самое то
        //lvMain.setAdapter(new FilmsAdapter(this,testlistfilms));
    }


    public ArrayList<Objfilm> initFilms() {
        ArrayList<Objfilm> testlistfilms;
        Provider somf = new Provider();
        testlistfilms=somf.generetefilm(10);
        /*testlistfilms.add(new Objfilm("Shkvarnoekino", 228, 228, 228, R.drawable.filmone));
        testlistfilms.add(new Objfilm("Muhosranskoekino", 999, 999, 999, R.drawable.filmone));
        testlistfilms.add(new Objfilm("Analniy popopehatel", 10, 10, 10, R.drawable.filmone));
        testlistfilms.add(new Objfilm("Analniy popopehatel 4", 14, 14, 14, R.drawable.filmone));
        testlistfilms.add(new Objfilm("Shvedskiy gandon", 001, 002, 003, R.drawable.filmone));
        testlistfilms.add(new Objfilm("Siskozilla", 10, 9, 8, R.drawable.filmone));
        testlistfilms.add(new Objfilm("Vietnamskoe obresanie", 0, 1, 0, R.drawable.filmone));
        testlistfilms.add(new Objfilm("Agent Musor", 228, 228, 007, R.drawable.filmone));
        testlistfilms.add(new Objfilm("Dristopocalipsis", 9, 7, 10, R.drawable.filmone));
        testlistfilms.add(new Objfilm("Dnevnik zhopnogo spida", 22, 30, 25, R.drawable.filmone));*/
        return testlistfilms;
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}