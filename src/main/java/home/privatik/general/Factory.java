package home.privatik.general;


import home.privatik.dao.AnimeDao;
import home.privatik.dao.AnimeDaoImpl;

public class Factory {

    private static Factory instance = new Factory();
    private AnimeDao animeDao;

    private Factory() {}

    public static Factory getInstance() {
        return Factory.instance;
    }

    public AnimeDao getAnimeDao() {
        if (animeDao == null)
            animeDao = new AnimeDaoImpl();
        return animeDao;
    }
}
