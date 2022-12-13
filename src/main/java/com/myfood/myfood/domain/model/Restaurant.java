package com.myfood.myfood.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Restaurant {
  
  @Id
  private Long id;

  @Column
  private String name;

  @Column(name = "freight_rate")
  private BigDecimal freightRate;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getFreightRate() {
    return this.freightRate;
  }

  public void setFreightRate(BigDecimal freightRate) {
    this.freightRate = freightRate;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this)
      return true;

    if (obj == null) 
      return false;

    if (getClass() != obj.getClass()) 
      return false;

    Restaurant other = (Restaurant) obj;

    if(id == null) {
      if(other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
