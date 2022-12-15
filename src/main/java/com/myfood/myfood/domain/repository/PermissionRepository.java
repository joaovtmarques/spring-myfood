package com.myfood.myfood.domain.repository;

import java.util.List;

import com.myfood.myfood.domain.model.Permission;

public interface PermissionRepository {
  
  List<Permission> findAll();

  Permission findById(Long id);

  Permission save(Permission kitchen);

  void remove(Permission kitchen);

}
