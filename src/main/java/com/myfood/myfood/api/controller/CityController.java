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
import com.myfood.myfood.domain.model.City;
import com.myfood.myfood.domain.repository.CityRepository;
import com.myfood.myfood.domain.service.CityService;

@RestController
@RequestMapping("/cities")
public class CityController {
  
  @Autowired
  private CityRepository cityRepository;

  @Autowired
  private CityService cityService;

  @GetMapping
  public List<City> findAll() {
    return cityRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<City> findOne(@PathVariable Long id) {

    City city = cityRepository.findById(id);

    if(city != null) {
      return ResponseEntity.ok().body(city);
    }

    return ResponseEntity.notFound().build();

  }

  @PostMapping
  public ResponseEntity<City> create(@RequestBody City city) {
    city = cityService.save(city);

    return ResponseEntity.status(HttpStatus.CREATED).body(city);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody City city) {
    try {
      City savedCity = cityRepository.findById(id);

      if(savedCity != null) {
        BeanUtils.copyProperties(city, savedCity, "id");

        savedCity = cityService.save(savedCity);

        return ResponseEntity.ok().body(savedCity);
      }

      return ResponseEntity.notFound().build();
    } catch (EntityNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

}
