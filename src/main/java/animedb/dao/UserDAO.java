package animedb.dao;

import animedb.domain.AnimesEntity;

import java.util.List;


public interface UserDAO {
    public List<AnimesEntity> list();

    public AnimesEntity getAnimeById(int id);
}
