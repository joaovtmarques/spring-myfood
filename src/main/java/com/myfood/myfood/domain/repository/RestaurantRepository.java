package com.myfood.myfood.domain.repository;

import java.util.List;

import com.myfood.myfood.domain.model.Restaurant;

public interface RestaurantRepository {
  
  List<Restaurant> findAll();

  Restaurant findById(Long id);

  Restaurant save(Restaurant kitchen);

  void remove(Restaurant kitchen);

}
