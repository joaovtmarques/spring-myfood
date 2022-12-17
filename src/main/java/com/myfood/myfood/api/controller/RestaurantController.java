package com.myfood.myfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfood.myfood.domain.model.Restaurant;
import com.myfood.myfood.domain.repository.RestaurantRepository;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
  
  @Autowired
  private RestaurantRepository restaurantRepository;


  @GetMapping
  public List<Restaurant> findAll() {
    return restaurantRepository.findAll();
  }
}
