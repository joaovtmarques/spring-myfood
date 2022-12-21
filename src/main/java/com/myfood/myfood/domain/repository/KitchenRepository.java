package com.myfood.myfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myfood.myfood.domain.model.Kitchen;

public interface KitchenRepository extends JpaRepository<Kitchen, Long> {

}
