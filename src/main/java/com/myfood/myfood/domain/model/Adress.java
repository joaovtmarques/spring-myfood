package com.myfood.myfood.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class Adress {
  
  @Column(name = "adress_zipcode")
  private String zipcode;
  
  @Column(name = "adress_public_place")
  private String publicPlace;

  @Column(name = "adress_number")
  private String number;

  @Column(name = "adress_complement")
  private String complement;

  @Column(name = "adress_district")
  private String district;

  @ManyToOne
  @JoinColumn(name = "adress_city_id")
  private City city;

}
