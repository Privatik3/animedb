package dao;

import domain.AnimeEntity;

import java.sql.SQLException;

public interface AnimeDao {

    public AnimeEntity getAnimeById(Integer animeID) throws SQLException;
}
