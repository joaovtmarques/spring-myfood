package com.myfood.myfood.domain.repository;

import java.util.List;

import com.myfood.myfood.domain.model.Kitchen;

public interface KitchenRepository {
  
  List<Kitchen> findAll();

  Kitchen findById(Long id);

  Kitchen save(Kitchen kitchen);

  void remove(Long id);

}
