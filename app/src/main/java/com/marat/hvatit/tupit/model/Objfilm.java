package com.marat.hvatit.tupit.model;

public class Objfilm {
    //Создание переменных класса

    //Название фильма
    private String name;
    //Ряд оценок,возможно создание массива assesments
    private int imdbone;
    private int imdbtwo;
    private int metacritic;
    //создание флажка
    private boolean favorite;
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
        this.favorite = favorite;
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
}
