package com.myfood.myfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myfood.myfood.domain.model.City;

public interface CityRepository extends JpaRepository<City, Long> {}
