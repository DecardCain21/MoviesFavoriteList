package com.marat.hvatit.tupit.model;

import com.marat.hvatit.tupit.model.interfaces.Provider;
import com.marat.hvatit.tupit.model.models.Filmmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneretorFilmmodel implements Provider<Filmmodel> {


    public ArrayList<Filmmodel> generateSomf(int count) {
        Random random = new Random();
        ArrayList<Filmmodel> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            //list.add(new Filmmodel(.setTitle("Film#" + String.valueOf(i)).setId(i).setPopularity(i + 10).setVideo(random.nextBoolean()).build());
        }
        return list;
    }

    @Override
    public List<Filmmodel> provide() {
        return generateSomf(10);
    }
}
