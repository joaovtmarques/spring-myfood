package com.myfood.myfood.domain.repository;

import java.util.List;

import com.myfood.myfood.domain.model.City;

public interface CityRepository {
  
  List<City> findAll();

  City findById(Long id);

  City save(City city);

  void remove(City city);

}
