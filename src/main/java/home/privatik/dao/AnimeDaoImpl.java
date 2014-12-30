package home.privatik.dao;


import home.privatik.domain.AnimeEntity;
import home.privatik.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

public class AnimeDaoImpl implements AnimeDao {

    @Override
    public AnimeEntity getAnimeById(String animeID) throws SQLException {

        AnimeEntity resualt = null;

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            resualt = (AnimeEntity) session.get(AnimeEntity.class, Integer.parseInt(animeID));
        } catch (Exception e) {
            System.err.println("Не удалось выгрузить аниме:");
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }

        return resualt;
    }
}
