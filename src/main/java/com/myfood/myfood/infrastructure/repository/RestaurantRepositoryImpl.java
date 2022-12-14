package com.myfood.myfood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myfood.myfood.domain.model.Restaurant;
import com.myfood.myfood.domain.repository.RestaurantRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Restaurant> findAll() {
    return manager.createQuery("from restaurant", Restaurant.class).getResultList();
  }

  @Override
  public Restaurant findById(Long id) {
    return manager.find(Restaurant.class, id);
  }

  @Transactional
  @Override
  public Restaurant save(Restaurant restaurant) {
    return manager.merge(restaurant);
  }

  @Transactional
  @Override
  public void remove(Restaurant restaurant) {
    restaurant = findById(restaurant.getId());
    manager.remove(restaurant);
  }
  
  

}
