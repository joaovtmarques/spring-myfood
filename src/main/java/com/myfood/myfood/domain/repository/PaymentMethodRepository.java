package com.myfood.myfood.domain.repository;

import java.util.List;

import com.myfood.myfood.domain.model.PaymentMethod;

public interface PaymentMethodRepository {
  
  List<PaymentMethod> findAll();

  PaymentMethod findById(Long id);

  PaymentMethod save(PaymentMethod paymentMethod);

  void remove(PaymentMethod paymentMethod);

}
