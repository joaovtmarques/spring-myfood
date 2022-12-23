package com.myfood.myfood.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurant {
  
  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column(name = "freight_rate")
  private BigDecimal freightRate;

  @ManyToOne
  private Kitchen kitchen;

  @JsonIgnore
  @ManyToMany
  @JoinTable(name = "restaurant_payment_method", inverseJoinColumns = @JoinColumn(name = "payment_method_id"))
  private List<PaymentMethod> paymentMethods = new ArrayList<>();
}
