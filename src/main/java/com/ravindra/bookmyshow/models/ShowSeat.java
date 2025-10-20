package com.ravindra.bookmyshow.models;

import com.ravindra.bookmyshow.models.enums.ShowSeatStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class ShowSeat extends BaseModal{
    private Show show;
    private Seat seat;
    private ShowSeatStatus showSeatStatus;
    private ShowSeatType showSeatType;
}


// We created this class because we need status of the seat for a particular show.