package com.marat.hvatit.tupit.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FilmCollectionStore {
    //Инициализация Map для хранения коллекции фильмов
    private final Map<String, Objfilm> cacheCollection;

    private static volatile FilmCollectionStore instance;


    private FilmCollectionStore() {
        //Объявление переменной
        cacheCollection = new HashMap<>();
        //Инициализация data(фильмов), с помощью генератора и интерфейса Provide
        List<Objfilm> collection = new GeneretorFilm().provide();
        //Внесение данных в коллекцию
        for (Objfilm film : collection) {
            cacheCollection.put(film.getName(), film);
        }
    }

    public static FilmCollectionStore getInstance(){
        if(instance==null){
            synchronized (FilmCollectionStore.class){
                if(instance==null)
                    instance = new FilmCollectionStore();
            }
            return instance;
        }
        return null;
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
}