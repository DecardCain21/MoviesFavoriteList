package com.marat.hvatit.tupit.model.filmmodel;


public class FilmGenre_ids {
    int[] genres;

    public FilmGenre_ids(int[] genresvalue) {
        this.genres = genresvalue;
    }


    public int[] getGenres() {
        return genres;
    }

    public void setGenres(int[] genres) {
        this.genres = genres;
    }
}
