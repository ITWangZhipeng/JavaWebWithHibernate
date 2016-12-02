package com.sec.test;

import com.sec.db.TongZhiDan;
import com.sec.db.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DBTest {
    Session session;
    Transaction transaction;
    Configuration configuration = new Configuration().configure();
    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
            .buildServiceRegistry();
    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    @Before
    public void start() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    @After
    public void end() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void Test() {
        User user1 = new User(10433208, "王志鹏", "111111");
        User user2 = new User(10433234, "秦小伟", "111111");
        User user3 = new User(10433207, "李兆辉", "111111");
        User user4 = new User(10432414, "陈福龙", "111111");

        Set<TongZhiDan> tongZhiDanSet = new HashSet<TongZhiDan>();

        TongZhiDan tongZhiDan1 = new TongZhiDan("设订单", "NOB10000SH30C065......");
        TongZhiDan tongZhiDan2 = new TongZhiDan("设订单", "NOB10000SH30C066......");
        TongZhiDan tongZhiDan3 = new TongZhiDan("设订单", "NOB10000SH30C067......");

        tongZhiDanSet.add(tongZhiDan1);
        tongZhiDanSet.add(tongZhiDan2);
        tongZhiDanSet.add(tongZhiDan3);

        user1.setTongZhiDens(tongZhiDanSet);

        session.save(tongZhiDan1);
        session.save(tongZhiDan2);
        session.save(tongZhiDan3);


        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.save(user4);

    }

    @Test
    public void Inquiry() {
        String hql = "from TongZhiDan where WorkID =:WorkID";
        Query query = session.createQuery(hql);
        query.setLong("WorkID", 10433208L);
        List<TongZhiDan> list = query.list();
        for(TongZhiDan users : list){
            System.out.println(users.toString());
        }
    }


}


