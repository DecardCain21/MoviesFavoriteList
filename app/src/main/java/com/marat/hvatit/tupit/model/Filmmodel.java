package com.marat.hvatit.tupit.model;

import java.util.ArrayList;

public class Filmmodel {
    boolean adult;
    String backdroppath;
    Object belongstocollection;
    int budget;
    ArrayList<Object> genres;
    String homepage;
    int id;
    String imdb_id;
    String original_language;
    String original_title;
    String overview;
    int popularity;//number
    String posterpath;
    ArrayList<Object> production_companies;//String name,int id,String logo_path,String origin_country
    ArrayList<Object> production_countries;//String iso_3166_1,String name
    String release_date;
    int revenue;
    int runtime;
    ArrayList<Object> spoken_languages;//String iso_639_1,String name
    String status;
    String tagline;
    String title;
    boolean video;
    int vote_average;//number
    int vote_count;
    //Добавление Favorite
    boolean favorite;
}

class FilmBuilderIMp implements IfilmBuilder {
    Filmmodel filmmodel = new Filmmodel();

    @Override
    public Filmmodel build() {
        return filmmodel;
    }

    @Override
    public IfilmBuilder setAdult(boolean adult) {
        filmmodel.adult = adult;
        return this;
    }

    @Override
    public IfilmBuilder setBackdroppath(String backdroppath) {
        filmmodel.backdroppath = backdroppath;
        return this;
    }

    @Override
    public IfilmBuilder setBelongstocollection(Object belongstocollection) {
        filmmodel.belongstocollection = belongstocollection;
        return this;
    }

    @Override
    public IfilmBuilder setBudget(int budget) {
        filmmodel.budget = budget;
        return this;
    }

    @Override
    public IfilmBuilder setGenres(ArrayList<Object> genres) {
        filmmodel.genres = genres;
        return this;
    }

    @Override
    public IfilmBuilder setHomepage(String homepage) {
        filmmodel.homepage = homepage;
        return this;
    }

    @Override
    public IfilmBuilder setId(int id) {
        filmmodel.id = id;
        return this;
    }

    @Override
    public IfilmBuilder setImdbid(String imdbid) {
        filmmodel.imdb_id = imdbid;
        return this;
    }

    @Override
    public IfilmBuilder setOriginal_language(String original_language) {
        filmmodel.original_language = original_language;
        return this;
    }

    @Override
    public IfilmBuilder setOriginal_title(String original_title) {
        filmmodel.original_title = original_title;
        return this;
    }

    @Override
    public IfilmBuilder setOverview(String overview) {
        filmmodel.overview = overview;
        return this;
    }

    @Override
    public IfilmBuilder setPopularity(int popularity) {
        filmmodel.popularity = popularity;
        return this;
    }

    @Override
    public IfilmBuilder setPosterpath(String posterpath) {
        filmmodel.posterpath = posterpath;
        return this;
    }

    @Override
    public IfilmBuilder setProduction_companies(ArrayList<Object> production_companies) {
        filmmodel.production_companies = production_companies;
        return this;
    }

    @Override
    public IfilmBuilder setProduction_countries(ArrayList<Object> production_countries) {
        filmmodel.production_countries = production_countries;
        return this;
    }

    @Override
    public IfilmBuilder setRelease_date(String release_date) {
        filmmodel.release_date = release_date;
        return this;
    }

    @Override
    public IfilmBuilder setRevenue(int revenue) {
        filmmodel.revenue = revenue;
        return this;
    }

    @Override
    public IfilmBuilder setRuntime(int runtime) {
        filmmodel.runtime = runtime;
        return this;
    }

    @Override
    public IfilmBuilder setSpoken_languages(ArrayList<Object> spoken_languages) {
        filmmodel.spoken_languages = spoken_languages;
        return this;
    }

    @Override
    public IfilmBuilder setStatus(String status) {
        filmmodel.status = status;
        return this;
    }

    @Override
    public IfilmBuilder setTagline(String tagline) {
        filmmodel.tagline = tagline;
        return this;
    }

    @Override
    public IfilmBuilder setTitle(String title) {
        filmmodel.title = title;
        return this;
    }

    @Override
    public IfilmBuilder setVideo(boolean video) {
        filmmodel.video = video;
        return this;
    }

    @Override
    public IfilmBuilder setVote_average(int vote_average) {
        filmmodel.vote_average = vote_average;
        return this;
    }

    @Override
    public IfilmBuilder setVote_count(int vote_count) {
        filmmodel.vote_count = vote_count;
        return this;
    }

    @Override
    public IfilmBuilder setFavorite(boolean favorite) {
        filmmodel.favorite = favorite;
        return this;
    }
}

interface IfilmBuilder {
    Filmmodel build();

    IfilmBuilder setAdult(boolean adult);

    IfilmBuilder setBackdroppath(String backdroppath);

    IfilmBuilder setBelongstocollection(Object belongstocollection);

    IfilmBuilder setBudget(int budget);

    IfilmBuilder setGenres(ArrayList<Object> genres);

    IfilmBuilder setHomepage(String homepage);

    IfilmBuilder setId(int id);

    IfilmBuilder setImdbid(String imdbid);

    IfilmBuilder setOriginal_language(String original_language);

    IfilmBuilder setOriginal_title(String original_title);

    IfilmBuilder setOverview(String overview);

    IfilmBuilder setPopularity(int popularity);

    IfilmBuilder setPosterpath(String posterpath);

    IfilmBuilder setProduction_companies(ArrayList<Object> production_companies);

    IfilmBuilder setProduction_countries(ArrayList<Object> production_countries);

    IfilmBuilder setRelease_date(String release_date);

    IfilmBuilder setRevenue(int revenue);

    IfilmBuilder setRuntime(int runtime);

    IfilmBuilder setSpoken_languages(ArrayList<Object> spoken_languages);

    IfilmBuilder setStatus(String status);

    IfilmBuilder setTagline(String tagline);

    IfilmBuilder setTitle(String title);

    IfilmBuilder setVideo(boolean video);

    IfilmBuilder setVote_average(int vote_average);

    IfilmBuilder setVote_count(int vote_count);

    IfilmBuilder setFavorite(boolean favorite);
}
