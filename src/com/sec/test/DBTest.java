package com.sec.test;

import com.sec.db.TongZhiDan;
import com.sec.db.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Before;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class DBTest {
    Session session;
    Transaction transaction;

    @Before
    public void start() {
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                .buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    @After
    public void end() {
        transaction.commit();
        session.close();
    }

    @Test
    public void Test(){
        User user = new User("10433208","王志鹏","111111");
        TongZhiDan tongZhiDan = new TongZhiDan("订单设", "工号B10000SH30C065......");
        Set<TongZhiDan> tongZhiDanSet = new HashSet<>();
        tongZhiDanSet.add(tongZhiDan);
        user.getTongZhiDens().add(tongZhiDan);

        session.save(tongZhiDan);
    }

}
