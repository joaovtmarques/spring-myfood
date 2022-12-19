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
import com.myfood.myfood.domain.model.Kitchen;
import com.myfood.myfood.domain.repository.KitchenRepository;
import com.myfood.myfood.domain.service.KitchenService;

@RestController
@RequestMapping("/kitchens")
public class KitchenController {
  
  @Autowired
  private KitchenRepository kitchenRepository;

  @Autowired
  private KitchenService kitchenService;

  @GetMapping
  public List<Kitchen> findAll() {
    return kitchenRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Kitchen> findById(@PathVariable Long id) {
    Kitchen kitchen = kitchenRepository.findById(id);
		
		if (kitchen != null) {
			return ResponseEntity.ok(kitchen);
		}
		
		return ResponseEntity.notFound().build();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody Kitchen kitchen) {
    kitchenService.save(kitchen);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Kitchen> update(@PathVariable Long id, @RequestBody Kitchen kitchen) {
    Kitchen savedKitchen = kitchenRepository.findById(id);
  
    if(savedKitchen != null) {
      BeanUtils.copyProperties(kitchen, savedKitchen, "id");
    
      savedKitchen = kitchenService.save(savedKitchen);
    
      return ResponseEntity.ok(savedKitchen);
    }

    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
	public ResponseEntity<Kitchen> remove(@PathVariable Long id) {
		try {
      kitchenService.remove(id);
      return ResponseEntity.noContent().build();
    } catch(EntityNotFoundException e) {
      return ResponseEntity.notFound().build();
    } catch (EntityInUseException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
