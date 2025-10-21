package com.ravindra.bookmyshow.models;

import com.ravindra.bookmyshow.models.enums.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class ShowSeat extends BaseModal{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
    @ManyToOne
    private ShowSeatType showSeatType;
}


// We created this class because we need status of the seat for a particular show.