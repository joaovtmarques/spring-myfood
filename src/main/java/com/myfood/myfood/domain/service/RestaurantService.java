package com.myfood.myfood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfood.myfood.domain.exception.EntityNotFoundException;
import com.myfood.myfood.domain.model.Kitchen;
import com.myfood.myfood.domain.model.Restaurant;
import com.myfood.myfood.domain.repository.KitchenRepository;
import com.myfood.myfood.domain.repository.RestaurantRepository;

@Service
public class RestaurantService {
  
  @Autowired
  private RestaurantRepository restaurantRepository;

  @Autowired
  private KitchenRepository kitchenRepository;

  public List<Restaurant> findAll() {
    return restaurantRepository.findAll();
  }

  public Restaurant findById(Long id) {
    return restaurantRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Restaurant %d not found", id)));
  }

  public Restaurant save(Restaurant restaurant) {
    Long kitchenId = restaurant.getKitchen().getId();

    Kitchen kitchen = kitchenRepository.findById(kitchenId).orElseThrow(() -> new EntityNotFoundException(String.format("Kitchen %d not found", kitchenId)));
    
    restaurant.setKitchen(kitchen);

    return restaurantRepository.save(restaurant);
  }

}
