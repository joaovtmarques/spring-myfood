package com.myfood.myfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.myfood.myfood.domain.exception.EntityInUseException;
import com.myfood.myfood.domain.exception.EntityNotFoundException;
import com.myfood.myfood.domain.model.City;
import com.myfood.myfood.domain.model.State;
import com.myfood.myfood.domain.repository.CityRepository;
import com.myfood.myfood.domain.repository.StateRepository;

@Service
public class CityService {
  
  @Autowired
  private CityRepository cityRepository;

  @Autowired
  private StateRepository stateRepository;

  public City save(City city) {
    Long stateId = city.getState().getId();

    State state = stateRepository.findById(stateId);

    if(state == null) {
      throw new EntityNotFoundException(String.format("State %d not found", stateId));
    }

    city.setState(state);

    return cityRepository.save(city);
  }

  public void remove(Long id) {
    try {
      cityRepository.remove(id);
    } catch(EmptyResultDataAccessException e) {
      throw new EntityNotFoundException(String.format("City %d not found", id));
    } catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String.format("City %d in use", id));
		}
  }

}
