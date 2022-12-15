package com.myfood.myfood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myfood.myfood.domain.model.PaymentMethod;
import com.myfood.myfood.domain.repository.PaymentMethodRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class PaymentMethodRepositoryImpl implements PaymentMethodRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<PaymentMethod> findAll() {
    return manager.createQuery("from payment_method", PaymentMethod.class).getResultList();
  }

  @Override
  public PaymentMethod findById(Long id) {
    return manager.find(PaymentMethod.class, id);
  }

  @Transactional
  @Override
  public PaymentMethod save(PaymentMethod paymentMethod) {
    return manager.merge(paymentMethod);
  }

  @Transactional
  @Override
  public void remove(PaymentMethod paymentMethod) {
    paymentMethod = findById(paymentMethod.getId());
    manager.remove(paymentMethod);
  }
}
