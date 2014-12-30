package animedb.dao.implement;

import animedb.dao.AnimeDao;
import animedb.domain.AnimeEntity;
import org.hibernate.Session;
import animedb.util.HibernateUtil;

import java.sql.SQLException;

public class AnimeDaoImpl implements AnimeDao {


    @Override
    public AnimeEntity getAnimeById(Integer animeID) throws SQLException {

        AnimeEntity resualt = null;

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            resualt = (AnimeEntity) session.get(AnimeEntity.class, animeID);
        } catch (Exception e) {
            System.err.println("Не удалось выгрузить аниме:");
            e.printStackTrace();
        } finally {
            /*if (session != null && session.isOpen())
                session.close();*/
        }

        return resualt;
    }
}