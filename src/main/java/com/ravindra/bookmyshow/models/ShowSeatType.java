package com.ravindra.bookmyshow.models;

import com.ravindra.bookmyshow.models.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModal{
  @ManyToOne
  private Show show;
  @Enumerated(EnumType.ORDINAL)
  private SeatType seatType;
  private double price;
}
