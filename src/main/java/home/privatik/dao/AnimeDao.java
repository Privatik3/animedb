package home.privatik.dao;

import home.privatik.domain.AnimeEntity;

import java.sql.SQLException;

public interface AnimeDao {

    public AnimeEntity getAnimeById(String animeID) throws SQLException;
}
