package com.nobel.service;

import java.util.List;

import com.nobel.model.Country;
import com.nobel.model.Laureate;

public interface LaureateService {

    Laureate findId(Integer id);

    List<Laureate> findAll();

    void updateOrSave(Laureate laureate);

    void delete(int ID);

    List<Country> laureatesPerCapita();
}