package com.myfood.myfood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfood.myfood.domain.exception.EntityNotFoundException;
import com.myfood.myfood.domain.model.Restaurant;
import com.myfood.myfood.domain.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

  @Autowired
  private RestaurantService restaurantService;

  @GetMapping
  public List<Restaurant> findAll() {
    return restaurantService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
    try {
			Restaurant restaurant = restaurantService.findById(id);
			return ResponseEntity.ok().body(restaurant);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody Restaurant restaurant) {
    try {
			restaurant = restaurantService.save(restaurant);
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Restaurant restaurant) {
    try {
      Restaurant savedRestaurant = restaurantService.findById(id);
  
      if(savedRestaurant != null) {
        BeanUtils.copyProperties(restaurant, savedRestaurant, "id", "paymentMethods");
      
        savedRestaurant = restaurantService.save(savedRestaurant);
      
        return ResponseEntity.ok(savedRestaurant);
      }

      return ResponseEntity.notFound().build();
    } catch (EntityNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
