package com.myfood.myfood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myfood.myfood.domain.model.Kitchen;

public interface KitchenRepository extends JpaRepository<Kitchen, Long> {

  List<Kitchen> findByNameContaining(String name);

}
