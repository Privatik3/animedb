package animedb.dao;

import java.util.List;

import animedb.domain.AnimesEntity;
import animedb.servise.Parametrs;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<AnimesEntity> list() {
        @SuppressWarnings("unchecked")
        List<AnimesEntity> listUser = (List<AnimesEntity>) sessionFactory.getCurrentSession()
                .createCriteria(AnimesEntity.class)
                .setMaxResults(20)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }

    @Override
    public AnimesEntity getAnimeById(int id) {
        return (AnimesEntity) sessionFactory.getCurrentSession()
                .get(AnimesEntity.class, id);
    }

    @Override
    public List getAnimeByParameters(Parametrs parametrs) {
        @SuppressWarnings("unchecked")
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AnimesEntity.class);

        //Тип сортировки
        switch (parametrs.getSortedType()) {
            case 1:  criteria.addOrder(Order.asc("main_title"));
                break;
            case 2:
                criteria.addOrder(Order.desc("average"));
                criteria.add(Restrictions.gt("voted", 100));
                break;
            case 3:  criteria.addOrder(Order.desc("voted"));
                break;
            case 4:  //по годам
                break;
            case 5:
                criteria.addOrder(Order.asc("ranced"));
                criteria.add(Restrictions.gt("ranced", 0));
        }

        //Тип производства
        if (parametrs.getType() > 0)
            criteria.add(Restrictions.eq("anime_type_id", parametrs.getType()));

        //Год производства
        if (parametrs.getDate() != null) {

            String startDate = parametrs.getDate();
            String endDate = Integer.toString(Integer.parseInt(parametrs.getDate()) + 1);

            //criteria.add()
        }

        //Жанры

        //Страница
        criteria.setFirstResult(parametrs.getPage() * 30);

        criteria.setMaxResults(30);

        return criteria.list();
    }
}