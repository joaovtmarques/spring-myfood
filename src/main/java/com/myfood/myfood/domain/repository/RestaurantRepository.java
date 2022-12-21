package com.myfood.myfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myfood.myfood.domain.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {}
