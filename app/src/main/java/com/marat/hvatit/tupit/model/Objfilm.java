package com.marat.hvatit.tupit.model;

import android.widget.TextView;

public class Objfilm {
    //Создание переменных класса

    //Название фильма
    private String name;
    //Ряд оценок,возможно создание массива assesments
    private int imdbone;
    private int imdbtwo;
    private int metacritic;
    //Создание Id объекта фильм
    private String filmId;
    //Создание описания фильма
    private String annotation;
    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }
    //создание флажка
    private boolean favorite;
    public static int NEW = 1;
    public static int FAVORITE =2;
    //public method for Provider

    public boolean isFavorite() {
        return favorite;
    }
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    //Номер изображения,превью для каждого объекта
    private int image;

    //Создание Конструктора
    public Objfilm(String name, int imdbone, int imdbtwo, int metacritic, int image) {
        this.name = name;
        this.imdbone = imdbone;
        this.imdbtwo = imdbtwo;
        this.metacritic = metacritic;
        this.image = image;
        this.favorite = false;
    }


    //Метод получения значения приватных переменных
    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getimdbone() {
        return imdbone;
    }

    public int getimdbtwo() {
        return imdbtwo;
    }

    public int getmetacritic() {
        return metacritic;
    }

    //Не работающие сеттеры :(
    public void setImage(int image) {
        this.image = image;
    }

    public String setName(String name) {
        return this.name;
    }

    public int setimdbone(int imdbone) {
        return this.imdbone;
    }

    public int setimdbtwo(int imdbtwo) {
        return this.imdbtwo;
    }

    public int setmetacritic(int metacritic) {
        return this.metacritic;
    }

    public int getType(){
        return isFavorite() ? NEW: FAVORITE;
    }
}
