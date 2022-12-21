package com.myfood.myfood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.myfood.myfood.domain.exception.EntityInUseException;
import com.myfood.myfood.domain.exception.EntityNotFoundException;
import com.myfood.myfood.domain.model.State;
import com.myfood.myfood.domain.repository.StateRepository;

@Service
public class StateService {
  
  @Autowired
  private StateRepository stateRepository;

  public List<State> findAll() {
    return stateRepository.findAll();
  }

  public State findById(Long id) {
    return stateRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException(String.format("State %d not found", id)));
  }

  public State save(State state) {
    return stateRepository.save(state);
  }

  public void remove(Long id) {
    try {
      stateRepository.deleteById(id);
    } catch(EmptyResultDataAccessException e) {
      throw new EntityNotFoundException(String.format("State %d not found", id));
    } catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String.format("State %d in use", id));
		}
  }

}
