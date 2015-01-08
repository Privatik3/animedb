package animedb.dao;

import animedb.domain.AnimesEntity;
import animedb.servise.Parametrs;

import java.util.List;


public interface UserDAO {
    public List<AnimesEntity> list();

    public AnimesEntity getAnimeById(int id);

    public List<AnimesEntity> getAnimeByParameters(Parametrs parametrs);

}
