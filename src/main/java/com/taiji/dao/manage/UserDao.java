package com.taiji.dao.manage;

import com.taiji.entity.manage.UserEntity;

/**
 * Created by Sleeb on 2017/4/18.
 */
public interface UserDao {

    UserEntity GetUser(Long userId);
}
