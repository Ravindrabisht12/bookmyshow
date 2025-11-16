package com.ravindra.bookmyshow.services;

import com.ravindra.bookmyshow.models.Show;
import com.ravindra.bookmyshow.models.ShowSeat;
import com.ravindra.bookmyshow.models.ShowSeatType;
import com.ravindra.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingAmountCalculator {
    private final ShowSeatTypeRepository showSeatTypeRepository;

    public BookingAmountCalculator(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public double calculateBookingAmount(Show show, List<ShowSeat> showSeats) {
        // Booking amount calculation logic will go here
        double amount = 0.0;

        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        for(ShowSeat showSeat : showSeats) {
            for(ShowSeatType showSeatType : showSeatTypes) {
                if(showSeat.getSeat().getSeatType() == showSeatType.getSeatType()) {
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }

        return amount;
    }
}
