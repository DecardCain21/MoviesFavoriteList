package com.marat.hvatit.tupit.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import com.marat.hvatit.tupit.model.interfaces.RowType;

public class Objfilm implements RowType {
    //Создание переменных класса

    //Название фильма
    private String name;
    //Ряд оценок,возможно создание массива assesments
    private int imdbone;
    private int imdbtwo;
    private int metacritic;


    public void setActers(String[] acters) {
        this.acters = acters;
    }

    //Тестовый пул актёров
    private String[] acters;

    public String getActers(int position) {
        return acters[position];
    }

    //Создание Id объекта фильм
    private String filmId;

    //Создание описания фильма
    private String annotation;

    protected Objfilm(Parcel in) {
        name = in.readString();
        imdbone = in.readInt();
        imdbtwo = in.readInt();
        metacritic = in.readInt();
        filmId = in.readString();
        annotation = in.readString();
        favorite = in.readByte() != 0;
        image = in.readInt();
    }


    //создание флажка
    private boolean favorite;

    private int filmType;


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
    public Objfilm(String name, int imdbone, int imdbtwo, int metacritic, int image, String filmId, String annotation, String[] acters) {
        this.name = name;
        this.imdbone = imdbone;
        this.imdbtwo = imdbtwo;
        this.metacritic = metacritic;
        this.image = image;
        this.favorite = false;
        this.filmId = filmId;
        this.annotation = annotation;
        this.acters = acters;
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

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getAnnotation() {
        return annotation;
    }

    //Тестовая типизация объекта

    public int getFilmType() {
        if(filmType==GRID_ROW_TYPE){
            return 3;
        }
        if(filmType==NEW_ROW_TYPE){
            return 2;
        }
        if(filmType==FAVORITE_ROW_TYPE){
            return 1;
        }
        else{
            return 0;
        }
    }

    public void setFilmType(int filmType) {
        this.filmType = filmType;
    }

}