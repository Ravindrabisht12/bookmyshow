package com.ravindra.bookmyshow.models;


import com.ravindra.bookmyshow.models.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModal{
    private String seatNumber;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    private int rowNumber;
    private int colNumber;

    @ManyToOne
    private Screen screen;
}
