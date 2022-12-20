package com.myfood.myfood.domain.service;

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

  public Restaurant save(Restaurant restaurant) {
    Long kitchenId = restaurant.getKitchen().getId();

    Kitchen kitchen = kitchenRepository.findById(kitchenId);

    if(kitchen == null) {
      throw new EntityNotFoundException(String.format("Kitchen %d not found", kitchenId));
    }

    restaurant.setKitchen(kitchen);

    return restaurantRepository.save(restaurant);
  }

}
