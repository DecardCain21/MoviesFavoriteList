package com.marat.hvatit.tupit.model.interfaces;

public interface Iobjfilm {
    String name = null;
    int imdbone = 0;
    int imdbtwo = 0;
    int metacritic = 0;

    String getName();

    int getimdbone();

    int getimdbtwo();

    int getmetacritic();

    String setName(String name);

    int setimdbone(int imdbone);

    int setimdbtwo(int imdbtwo);

    int setmetacritic(int metacritic);
}
