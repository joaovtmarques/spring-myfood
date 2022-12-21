package com.myfood.myfood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.myfood.myfood.domain.model.Kitchen;
import com.myfood.myfood.domain.exception.EntityInUseException;
import com.myfood.myfood.domain.exception.EntityNotFoundException;
import com.myfood.myfood.domain.repository.KitchenRepository;

@Service
public class KitchenService {
  
  @Autowired
  private KitchenRepository kitchenRepository;

  public List<Kitchen> findAll() {
    return kitchenRepository.findAll();
  }

  public Kitchen findById(Long id) {
    return  kitchenRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Kitchen %d not found", id)));
  }

  public Kitchen save(Kitchen kitchen) {
    return kitchenRepository.save(kitchen);
  }

  public void remove(Long id) {
    try {
      kitchenRepository.deleteById(id);
    } catch(EmptyResultDataAccessException e) {
      throw new EntityNotFoundException(String.format("Kitchen %d not found", id));
    } catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String.format("Kitchen %d in use", id));
		}
  }

}
