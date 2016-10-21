package com.endava.spring.dao;

import com.endava.spring.entity.Dance;
import com.endava.spring.entity.Man;
import com.endava.spring.entity.Woman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ManDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addMan(Man man) {
        Session session = sessionFactory.openSession();
        session.save(man);
        System.out.println("Man added: " + man.getName());
    }

    public void editMan(Man man) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(man);
        System.out.println("Man updated: " + man.getName());
    }

    public void editMansName(String name, String newName) {
        Session session = sessionFactory.openSession();
        Man man = (Man) session.createQuery("from Man where name='" + name + "'").uniqueResult();
        man.setName(newName);
        session.update(man);
        System.out.printf("Man's name  updated. Old name: %s, new name: %s\n", name, newName);
    }

    public void deleteManByName(String name) {
        Session session = sessionFactory.openSession();
        Man man = (Man) session.createQuery("from Man where name='" + name + "'").uniqueResult();
        session.delete(man);
        System.out.println("Man was deleted " + name);
    }

    public Man getManByName(String name) {
        Session session = sessionFactory.openSession();
        Man man = (Man) session.createQuery("from Man where name='" + name + "'").uniqueResult();
        return man;
    }

    public List<Man> getListOfMen() {
        Session session = sessionFactory.openSession();
        return session.createQuery("FROM Man").list();
    }

    public Set<Dance> getHisDances(int id) {
        Session session = sessionFactory.openSession();
        Man man = (Man) session.get(Man.class, id);
        return man.getAllPersonsDances();
    }

    public Collection<Woman> getHisPartners(int id) {
        Session session = sessionFactory.openSession();
        Man man = (Man) session.get(Man.class, id);
        Set<Woman> partners = new HashSet<Woman>();
        for (Dance dance : getHisDances(id)) {
            partners.add(dance.getWoman());
        }
        System.out.println(partners);
        return partners;
    }

}
