package com.myfood.myfood.domain.repository;

import java.util.List;

import com.myfood.myfood.domain.model.State;

public interface StateRepository {
  
  List<State> findAll();

  State findById(Long id);

  State save(State state);

  void remove(Long id);

}
