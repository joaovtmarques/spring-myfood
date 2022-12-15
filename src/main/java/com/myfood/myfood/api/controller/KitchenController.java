package com.myfood.myfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfood.myfood.domain.model.Kitchen;
import com.myfood.myfood.domain.repository.KitchenRepository;

@RestController
@RequestMapping("/kitchens")
public class KitchenController {
  
  @Autowired
  private KitchenRepository kitchenRepository;

  @GetMapping
  public List<Kitchen> findAll() {
    return kitchenRepository.findAll();
  }
}
