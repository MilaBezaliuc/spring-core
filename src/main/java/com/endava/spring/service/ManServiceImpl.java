package com.endava.spring.service;


import com.endava.spring.dao.ManDao;
import com.endava.spring.entity.Dance;
import com.endava.spring.entity.Man;
import com.endava.spring.entity.Woman;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ManServiceImpl {

    @Autowired
    private ManDao manDao;

    @Transactional
    public void addMan(Man man) {
        manDao.addMan(man);
    }

    @Transactional
    public void editMansName(String name, String newName) {
        manDao.editMansName(name, newName);
    }

    @Transactional
    public void deleteManByName(String name) {
        manDao.deleteManByName(name);
    }

    @Transactional
    public Man getManByName(String name) {
        return manDao.getManByName(name);
    }

    @Transactional
    public List<Man> getListOfMen() {
        return manDao.getListOfMen();
    }

    @Transactional
    public Set<Dance> getHisDances(int id) {
        return manDao.getHisDances(id);
    }

    @Transactional
    public Collection<Woman> getHisPartners(int id) {
        return manDao.getHisPartners(id);
    }
}
