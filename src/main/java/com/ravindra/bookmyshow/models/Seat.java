package com.ravindra.bookmyshow.models;


import com.ravindra.bookmyshow.models.enums.SeatType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModal{
    private String seatNumber;
    private SeatType seatType;
    private int row;
    private int col;
}
