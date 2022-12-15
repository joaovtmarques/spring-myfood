package com.myfood.myfood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myfood.myfood.domain.model.Kitchen;
import com.myfood.myfood.domain.repository.KitchenRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class KitchenRepositoryImpl implements KitchenRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Kitchen> findAll() {
    return manager.createQuery("from kitchen", Kitchen.class).getResultList();
  }

  @Override
  public Kitchen findById(Long id) {
    return manager.find(Kitchen.class, id);
  }

  @Transactional
  @Override
  public Kitchen save(Kitchen kitchen) {
    return manager.merge(kitchen);
  }

  @Transactional
  @Override
  public void remove(Kitchen kitchen) {
    kitchen = findById(kitchen.getId());
    manager.remove(kitchen);
  }
  
  

}
