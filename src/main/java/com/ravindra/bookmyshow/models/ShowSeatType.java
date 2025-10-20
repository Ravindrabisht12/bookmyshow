package com.ravindra.bookmyshow.models;

import com.ravindra.bookmyshow.models.enums.SeatType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ShowSeatType extends BaseModal{
  private Show show;
  private SeatType seatType;
  private double price;
}
