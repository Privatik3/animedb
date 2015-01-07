package animedb.dao;

import java.util.List;

import animedb.domain.AnimesEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<AnimesEntity> list() {
        @SuppressWarnings("unchecked")
        List<AnimesEntity> listUser = (List<AnimesEntity>) sessionFactory.getCurrentSession()
                .createCriteria(AnimesEntity.class)
                .setMaxResults(10)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }

}