package com.endava.spring.dao;

import com.endava.spring.entity.Dance;
import com.endava.spring.entity.Man;
import com.endava.spring.entity.Woman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class WomanDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addWoman(Woman woman) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(woman);
        System.out.println("Woman added " + woman.getName());
    }

    @Transactional
    public void editWomansName(String name, String newName) {
        Session session = sessionFactory.openSession();
        Woman woman = (Woman) session.createQuery("from Woman where name=:name").setParameter("name", name).uniqueResult();
        woman.setName(newName);
        session.update(woman);
        System.out.printf("Woman's name  updated. Old name: %s, new name: %s\n", name, newName);
    }

    @Transactional
    public void deleteWomanByName(String name) {
        Session session = sessionFactory.openSession();
        Woman woman = (Woman) session.createQuery("from Woman where name=:name").setParameter("name", name).uniqueResult();
        session.delete(woman);
        System.out.println("Woman was deleted " + name);
    }

    @Transactional
    public Woman getWomanByName(String name) {
        Session session = sessionFactory.openSession();
        Woman woman = (Woman) session.createQuery("from Woman where name=:name")
                .setParameter("name", name).uniqueResult();
        return woman;
    }

    @Transactional
    public List<Woman> getListOfWomen() {
        Session session = sessionFactory.openSession();
        return session.createQuery("FROM Woman ").list();
    }

    @Transactional
    public Set<Dance> getHerDances(String name) {
        Session session = sessionFactory.openSession();
        Woman woman = (Woman) session.createQuery("from Woman where name=:name")
                .setParameter("name", name).uniqueResult();
        return woman.getAllWomansDances();
    }

    @Transactional
    public List<Man> getHerPartners(String name) {
        Session session = sessionFactory.openSession();
        Woman woman = (Woman) session.createQuery("from Woman where name=:name")
                .setParameter("name", name).uniqueResult();
        List<Man> partners = new ArrayList<Man>();
        for (Dance dance : getHerDances(name)) {
            partners.add(dance.getMan());
        }
        return partners;
    }

}

