package com.myfood.myfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfood.myfood.domain.model.State;
import com.myfood.myfood.domain.repository.StateRepository;

@RestController
@RequestMapping("/states")
public class StateController {
  
  @Autowired
  private StateRepository stateRepository;

  @GetMapping
  public List<State> findAll() {
    return stateRepository.findAll();
  }

}
