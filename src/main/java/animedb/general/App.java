package animedb.general;

import animedb.dao.AnimeDao;
import animedb.domain.AnimesEntity;
import animedb.util.HibernateUtil;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {


        AnimeDao animeDao = Factory.getInstance().getAnimeDao();

        AnimesEntity animeEntity = animeDao.getAnimeById(10);

        System.out.println(animeEntity.getMainTitle());

        HibernateUtil.closeSession();
    }
}
