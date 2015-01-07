package home.privatik.spring.dao;

import home.privatik.spring.domain.AnimesEntity;
import home.privatik.spring.domain.UsersEntity;
import java.util.List;


public interface UserDAO {
    public List<AnimesEntity> list();
}
