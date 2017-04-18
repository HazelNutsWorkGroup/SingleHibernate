package com.taiji.dao.manage;

import com.taiji.common.util.SnowflakeIdWorker;
import com.taiji.entity.manage.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Sleeb on 2017/4/18.
 */
public class HibernateTest {

    //1. 配置类型安全的准服务注册类，这是当前应用的单例对象，不作修改，所以声明为final
    //在configure("cfg/hibernate.cfg.xml")方法中，如果不指定资源路径，默认在类路径下寻找名为hibernate.cfg.xml的文件
    private final static StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    private static SessionFactory sessionFactory;
    private static SnowflakeIdWorker snowflakeIdWorker;
    private Session session;

    @BeforeClass
    public static void initializeClass(){
        //2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        snowflakeIdWorker=new SnowflakeIdWorker(0,0);
    }

    @Before
    public void initializeField(){
        //3. 从会话工厂获取一个session
        session = sessionFactory.openSession();
    }

    @Test
    public void Insert(){
        //开启一个新的事务
        Transaction transaction = session.beginTransaction();

        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(snowflakeIdWorker.nextId());
        userEntity.setUserName("Hibernate Test");
        session.save(userEntity);

        //提交一个事务
        transaction.commit();
    }
}
