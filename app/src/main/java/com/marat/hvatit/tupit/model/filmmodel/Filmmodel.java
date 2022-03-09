package com.marat.hvatit.tupit.model.filmmodel;

public class Filmmodel {

    boolean adult;
    String backdroppath;
    FilmGenre_ids filmGenre_ids;
    int id;
    String original_language;
    String original_title;
    String overview;
    int popularity;//number
    String posterpath;
    String release_date;
    String title;
    boolean video;
    int vote_average;//number
    int vote_count;
    //Добавление Favorite
    boolean favorite;

    public Filmmodel(boolean adult, String backdroppath, FilmGenre_ids filmGenre_ids, int id, String original_language, String original_title, String overview, int popularity, String posterpath, String release_date, String title, boolean video, int vote_average, int vote_count, boolean favorite) {
        this.adult = adult;
        this.backdroppath = backdroppath;
        this.filmGenre_ids = filmGenre_ids;
        this.id = id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.posterpath = posterpath;
        this.release_date = release_date;
        this.title = title;
        this.video = video;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.favorite = favorite;
    }

}
