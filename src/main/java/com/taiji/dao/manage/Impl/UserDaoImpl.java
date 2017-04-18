package com.taiji.dao.manage.Impl;

import com.taiji.dao.manage.UserDao;
import com.taiji.entity.manage.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Sleeb on 2017/4/18.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public UserEntity GetUser(Long userId) {
        return hibernateTemplate.get(UserEntity.class,userId);
    }
}
