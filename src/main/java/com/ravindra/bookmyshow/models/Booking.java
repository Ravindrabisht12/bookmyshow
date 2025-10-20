package com.ravindra.bookmyshow.models;


import com.ravindra.bookmyshow.models.enums.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModal{
    private String bookingNumber;
    @ManyToOne
    private User user;
    @ManyToOne
    private Show show;
    @ManyToMany
    private List<ShowSeat> showSeats;
    private double amount;
    @OneToMany
    private List<Payment> payments;
    private BookingStatus bookingStatus;
}

/**
 *    1            1
 * Booking ----- User M:1
 *    M             1
 *
 *   1             1
 * Booking ----- Show M:M
 *   M             1
 *
 *   1             M
 * Booking ----- ShowSeat M:M   // Many booking because we have option to cancel booking for few seats
 *   M             1
 *
 *  1             M
 * Booking ----- Payment 1:M
 *  1               1
 */