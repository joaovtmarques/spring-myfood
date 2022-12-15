package com.myfood.myfood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myfood.myfood.domain.model.Permission;
import com.myfood.myfood.domain.repository.PermissionRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class PermissionRepositoryImpl implements PermissionRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Permission> findAll() {
    return manager.createQuery("from permission", Permission.class).getResultList();
  }

  @Override
  public Permission findById(Long id) {
    return manager.find(Permission.class, id);
  }

  @Transactional
  @Override
  public Permission save(Permission permission) {
    return manager.merge(permission);
  }

  @Transactional
  @Override
  public void remove(Permission permission) {
    permission = findById(permission.getId());
    manager.remove(permission);
  }
  
  

}
