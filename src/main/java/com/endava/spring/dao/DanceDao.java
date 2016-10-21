package com.endava.spring.dao;

import com.endava.spring.entity.Dance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public class DanceDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addDance(Dance dance) {
        Session session = sessionFactory.openSession();
        session.save(dance);
        System.out.printf("Dance added. %s and %s were dancing %s\n", dance.getMan().getName(), dance.getWoman().getName(), dance.getStyle());
    }

    public void deleteDance(int id) {
        Session session = sessionFactory.openSession();
        Dance dance = (Dance) session.get(Dance.class, id);
        if (dance != null) session.delete(dance);
        System.out.println("Dance deleted");
    }

    public Collection<Dance> listOfDances() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Dance ").list();
    }

}
