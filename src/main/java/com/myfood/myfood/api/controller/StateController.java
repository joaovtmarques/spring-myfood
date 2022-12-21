package com.myfood.myfood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myfood.myfood.domain.exception.EntityInUseException;
import com.myfood.myfood.domain.exception.EntityNotFoundException;
import com.myfood.myfood.domain.model.State;
import com.myfood.myfood.domain.service.StateService;

@RestController
@RequestMapping("/states")
public class StateController {

  @Autowired
  private StateService stateService;

  @GetMapping
  public List<State> findAll() {
    return stateService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findOne(@PathVariable Long id) {
    try {
      State state = stateService.findById(id);

      return ResponseEntity.ok().body(state);
    } catch (EntityNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<State> create(@RequestBody State state) {
    state = stateService.save(state);

    return ResponseEntity.status(HttpStatus.CREATED).body(state);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody State state) {
    try {
      State savedState = stateService.findById(id);

      if(savedState != null) {
        BeanUtils.copyProperties(state, savedState, "id");

        savedState = stateService.save(savedState);

        return ResponseEntity.ok().body(savedState);
      }

      return ResponseEntity.notFound().build();
    } catch (EntityNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<State> remove(@PathVariable Long id) {
    try {
      stateService.remove(id);
      return ResponseEntity.noContent().build();
    } catch (EntityNotFoundException e) {
      return ResponseEntity.notFound().build();
    } catch (EntityInUseException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
  }

}
