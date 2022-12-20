package com.myfood.myfood.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myfood.myfood.domain.model.City;
import com.myfood.myfood.domain.repository.CityRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class CityRepositoryImpl implements CityRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<City> findAll() {
    return manager.createQuery("from City", City.class).getResultList();
  }

  @Override
  public City findById(Long id) {
    return manager.find(City.class, id);
  }

  @Transactional
  @Override
  public City save(City city) {
    return manager.merge(city);
  }

  @Transactional
  @Override
  public void remove(Long id) {
    City city = findById(id);

    if(city == null) {
      throw new EmptyResultDataAccessException(1);
    }

    manager.remove(city);
  }
}
