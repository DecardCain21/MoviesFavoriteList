package com.marat.hvatit.tupit.model;

import com.marat.hvatit.tupit.R;

import java.util.ArrayList;
import java.util.Random;

public abstract class Provider<T> {
    private ArrayList<T> data;

    public ArrayList<T> getData() {
        return data;
    }

    public Provider(int x) {
        this.data = genereteSomf(x);
    }

    public ArrayList<T> genereteSomf(int x) {
        return new ArrayList<T>();
    }
}
