package animedb.dao;

import animedb.domain.AnimesEntity;
import org.hibernate.Session;

import java.sql.SQLException;

public interface AnimeDao {

    public AnimesEntity getAnimeById(int animeId) throws SQLException;
}
