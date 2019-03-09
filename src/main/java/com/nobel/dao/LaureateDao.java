package com.nobel.dao;

import java.util.List;

import com.nobel.model.Country;
import com.nobel.model.Laureate;

public interface LaureateDao {

    Laureate findId(Integer id);

    List<Laureate> findAll();

    void delete(Integer id);

    void save(Laureate laureate);

    void update(Laureate laureate);

    List<Country> laureatesPerCapita();
}