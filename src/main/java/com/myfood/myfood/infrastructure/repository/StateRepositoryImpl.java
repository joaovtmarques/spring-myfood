package com.myfood.myfood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myfood.myfood.domain.model.State;
import com.myfood.myfood.domain.repository.StateRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class StateRepositoryImpl implements StateRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<State> findAll() {
    return manager.createQuery("from state", State.class).getResultList();
  }

  @Override
  public State findById(Long id) {
    return manager.find(State.class, id);
  }

  @Transactional
  @Override
  public State save(State state) {
    return manager.merge(state);
  }

  @Transactional
  @Override
  public void remove(State state) {
    state = findById(state.getId());
    manager.remove(state);
  }
  
  

}
