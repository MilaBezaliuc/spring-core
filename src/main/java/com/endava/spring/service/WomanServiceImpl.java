package com.endava.spring.service;


import com.endava.spring.dao.WomanDao;
import com.endava.spring.entity.Dance;
import com.endava.spring.entity.Man;
import com.endava.spring.entity.Woman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class WomanServiceImpl {

    @Autowired
    private WomanDao womanDao;

    @Transactional
    public void addWoman(Woman woman) {
        womanDao.addWoman(woman);
    }

    @Transactional
    public void editWomansName(String name, String newName) {
        womanDao.editWomansName(name, newName);
    }

    @Transactional
    public void deleteWomanByName(String name) {
        womanDao.deleteWomanByName(name);
    }

    @Transactional
    public Woman getWomanByName(String name) {
        return womanDao.getWomanByName(name);
    }

    @Transactional
    public List<Woman> getListOfWomen() {
        return womanDao.getListOfWomen();
    }

    @Transactional
    public Set<Dance> getHisDances(String name) {
        return womanDao.getHerDances(name);
    }

    @Transactional
    public Collection<Man> getHisPartners(String name) {
        return womanDao.getHerPartners(name);
    }
}
