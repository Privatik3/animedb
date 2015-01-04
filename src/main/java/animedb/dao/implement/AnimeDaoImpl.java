package animedb.dao.implement;

import animedb.dao.AnimeDao;
import animedb.domain.AnimesEntity;
import animedb.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

public class AnimeDaoImpl implements AnimeDao {

    @Override
    public AnimesEntity getAnimeById(int animeId) throws SQLException {
        AnimesEntity animesEntity = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            animesEntity = (AnimesEntity) session.get(AnimesEntity.class, animeId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return animesEntity;
    }
}
