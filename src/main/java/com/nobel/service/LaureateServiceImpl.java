package com.nobel.service;

import java.util.List;

import com.nobel.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nobel.dao.LaureateDao;
import com.nobel.model.Laureate;

@Service("laureateService")
public class LaureateServiceImpl implements LaureateService {

    private LaureateDao laureateDao;

    @Autowired
    public void setLaureateDao(LaureateDao laureateDao) {
        this.laureateDao = laureateDao;
    }

    @Override
    public Laureate findId(Integer id) {
        return laureateDao.findId(id);
    }

    @Override
    public List<Laureate> findAll() {
        return laureateDao.findAll();
    }

    @Override
    public void delete(int ID) {
        laureateDao.delete(ID);
    }

    @Override
    public List<Country> laureatesPerCapita() {
        return laureateDao.laureatesPerCapita();
    }

    @Override
    public void updateOrSave(Laureate laureate) {

        if (findId(laureate.getId()) == null) {
            laureateDao.save(laureate);
        } else {
            laureateDao.update(laureate);
        }
    }
}