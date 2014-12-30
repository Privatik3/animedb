package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public HibernateUtil() {}

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
