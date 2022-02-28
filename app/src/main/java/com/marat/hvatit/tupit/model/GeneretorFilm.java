package com.marat.hvatit.tupit.model;

import com.marat.hvatit.tupit.R;
import com.marat.hvatit.tupit.model.interfaces.Provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneretorFilm implements Provider<Objfilm> {
    ArrayList<Objfilm> list;


    public ArrayList <Objfilm> genereteSomf(int count) {
        Random random = new Random();
        ArrayList<Objfilm> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new Objfilm("Film#" + String.valueOf(i), i, i + 1, i + 2, R.drawable.filmone , String.valueOf(i),"Film annotation#" + String.valueOf(i), new String[]{"h", "u","i raiting","15031045"}));
            list.get(i).setFilmType(random.nextInt(2));
            list.get(i).setFavorite(random.nextBoolean());
        }
        return list;
    }

    @Override
    public List<Objfilm> provide() {
        return genereteSomf(10);
    }
}
