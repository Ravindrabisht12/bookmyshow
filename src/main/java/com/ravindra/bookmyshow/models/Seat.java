package com.ravindra.bookmyshow.models;


import com.ravindra.bookmyshow.models.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModal{
    private int rowNum;
    private int colNum;
    private String number;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
}
