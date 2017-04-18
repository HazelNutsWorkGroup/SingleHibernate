package com.taiji.service.manage;

import com.taiji.domain.manage.UserDomain;
import com.taiji.entity.manage.UserEntity;

/**
 * Created by Sleeb on 2017/4/18.
 */
public interface UserService {

    UserDomain GetUser(Long userId);

    UserDomain convertEntityToDomain(UserEntity userEntity);

    UserEntity convertDomainToEntity(UserDomain userDomain);
}
