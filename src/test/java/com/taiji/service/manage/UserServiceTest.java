package com.taiji.service.manage;

import com.taiji.domain.manage.UserDomain;
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
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void TestGetUser() {
        UserDomain userDomain = userService.GetUser(1L);

        Assert.assertEquals("Test001", userDomain.getUserName());
    }
}
