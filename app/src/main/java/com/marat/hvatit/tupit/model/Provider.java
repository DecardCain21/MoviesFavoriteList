package com.marat.hvatit.tupit.model;

import com.marat.hvatit.tupit.R;

import java.util.ArrayList;
import java.util.Random;

public class Provider {

    public Provider() {

    }

    public ArrayList<Objfilm> generetefilm(int x) {
        Random random = new Random();
        ArrayList<Objfilm> list = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            list.add(new Objfilm("Film#" + String.valueOf(i), i, i + 1, i + 2, R.drawable.filmone));
            list.get(i).setFavorite(random.nextBoolean());
        }
        return list;
    }
}
