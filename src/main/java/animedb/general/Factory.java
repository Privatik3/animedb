package animedb.general;

import animedb.dao.AnimeDao;
import animedb.dao.implement.AnimeDaoImpl;

public class Factory {

    public static Factory instance = new Factory();
    public AnimeDao animeDao;

    private Factory() {}

    public static Factory getInstance() {
        return Factory.instance;
    }

    public AnimeDao getAnimeDao() {
        if (animeDao == null)
            return animeDao = new AnimeDaoImpl();
        return animeDao;
    }
}
