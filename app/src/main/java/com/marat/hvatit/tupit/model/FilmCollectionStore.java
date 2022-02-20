package com.marat.hvatit.tupit.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FilmCollectionStore {
    //Инициализация Map для хранения коллекции фильмов
    private final Map<String, Objfilm> cacheCollection;
    private static FilmCollectionStore mInstance;


    private FilmCollectionStore() {
        //Объявление переменной
        cacheCollection = new HashMap<>();
        //Инициализация data(фильмов), с помощью генератора и интерфейса Provide
        List<Objfilm> collection = new GeneretorFilm().provide();
        //Внесение данных в коллекцию
        for (Objfilm film : collection) {
            cacheCollection.put(film.getFilmId(), film);
        }
    }

    //Создание вложенного класса,для решения проблемы "ленивой инициализации"
    private static class FilmCollectionStoreHolder {
        private final static FilmCollectionStore instance = new FilmCollectionStore();
    }

    public static FilmCollectionStore getInstance() {
        if(mInstance==null){
            mInstance = new FilmCollectionStore();
        }
        return mInstance;
    }


    //Метод получения конкретного фильма по filmId
    public Objfilm getFilm(String filmId) {
        return cacheCollection.get(filmId);
    }

    //Получение всей коллекции(к примеру в адаптере)
    public ArrayList<Objfilm> getCollection() {
        return new ArrayList<Objfilm>(cacheCollection.values());
    }

    //Добавление конкретного фильма в коллекцию,данная реализация не гарантирует порядка элементов
    public void putFilm(Objfilm film) {
        cacheCollection.put(film.getName(), film);
    }

    @Override
    public String toString() {
        return "FilmCollectionStore{" +
                "cacheCollection=" + cacheCollection +
                '}';
    }
}
