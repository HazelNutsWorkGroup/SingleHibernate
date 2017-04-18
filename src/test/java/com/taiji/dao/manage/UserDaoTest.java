package com.taiji.dao.manage;

import com.taiji.entity.manage.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Sleeb on 2017/4/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-hibernate.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void TestGetUser() {
        UserEntity userEntity = userDao.GetUser(1L);

        Assert.assertEquals("Test001", userEntity.getUserName());
    }
}
