package com.endava.spring.service;

import com.endava.spring.dao.DanceDao;
import com.endava.spring.entity.Dance;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class DanceServiceImlp {

    @Autowired
    private DanceDao danceDao;

    @Transactional
    public void addDance(Dance dance) {
        danceDao.addDance(dance);
    }

    @Transactional
    public void deleteDance(int id) {
        danceDao.deleteDance(id);
    }

    @Transactional
    public Collection<Dance> listOfDances() {
        return danceDao.listOfDances();
    }

}
