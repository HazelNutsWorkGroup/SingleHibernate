package com.taiji.service.manage.Impl;

import com.taiji.dao.manage.UserDao;
import com.taiji.domain.manage.UserDomain;
import com.taiji.entity.manage.UserEntity;
import com.taiji.service.manage.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Sleeb on 2017/4/18.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserDao userDao;

    @Override
    public UserDomain GetUser(Long userId) {
        UserEntity userEntity = userDao.GetUser(userId);


        UserDomain userDomain =convertEntityToDomain(userEntity);
        return userDomain;
    }

    @Override
    public UserDomain convertEntityToDomain(UserEntity userEntity) {
        if(userEntity==null)
            return null;
        logger.warn("userEntity:",userEntity);

        UserDomain userDomain=new UserDomain();
        userDomain.setUserId(userEntity.getUserId());
        userDomain.setUserName(userEntity.getUserName());
        userDomain.setUserCode(userEntity.getUserCode());
        userDomain.setPassword(userEntity.getPassword());

        return userDomain;
    }

    @Override
    public UserEntity convertDomainToEntity(UserDomain userDomain) {
        if(userDomain==null)
            return null;

        UserEntity userEntity=new UserEntity();
        userEntity.setUserId(userDomain.getUserId());
        userEntity.setUserName(userDomain.getUserName());
        userEntity.setUserCode(userDomain.getUserCode());
        userEntity.setPassword(userDomain.getPassword());

        return userEntity;
    }
}
