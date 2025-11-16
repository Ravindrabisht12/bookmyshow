package com.ravindra.bookmyshow.services;

import com.ravindra.bookmyshow.models.Booking;
import com.ravindra.bookmyshow.models.Show;
import com.ravindra.bookmyshow.models.ShowSeat;
import com.ravindra.bookmyshow.models.User;
import com.ravindra.bookmyshow.models.enums.BookingStatus;
import com.ravindra.bookmyshow.models.enums.ShowSeatStatus;
import com.ravindra.bookmyshow.repositories.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final UserRepository userRepository;
    private final BookingAmountCalculator bookingAmountCalculator;

    public BookingService(BookingRepository bookingRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, UserRepository userRepository, BookingAmountCalculator bookingAmountCalculator){
        this.bookingRepository = bookingRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.bookingAmountCalculator = bookingAmountCalculator;
    }

    public Booking createBooking(Long userId, List<Long> showSeatIds, Long showId) {
        // Booking creation logic will go here
        /**
         1. Get the user with the given userId
         2. Get the show with the given showId
         3. Get the list if show seats with the given id's
         --------- TAKE A LOCK ------------
         4. Check if all the seats are available or not
         5. if not, throw an exception
         6. If yes, mark the status of all the seats as BLOCKED
         7. Persist the changes in the DB
         --------- RELEASE THE LOCK ------------
         8. Create a booking with PENDING status [save the Booking in DB]
         9. Return the Booking object
         */

        // 1. Get the user with the given userId
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User user = userOptional.get();

        //  2. Get the show with the given showId
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()) {
            throw new RuntimeException("Show not found");
        }
        Show show = showOptional.get();

        // 3. Get all the list of showSeats using the given showSeatIds
        List<ShowSeat> showSeats =  showSeatRepository.findAllById(showSeatIds);
        if(showSeats.size() != showSeatIds.size()) {
            throw new RuntimeException("Some show seats are not found");
        }

        //  4. Check if all the seats are available or not
        //  5. if not, throw an exception
        for(ShowSeat showSeat : showSeats) {
            if(showSeat.getShowSeatStatus() != ShowSeatStatus.AVAILABLE) {
                throw new RuntimeException("Seat " + showSeat.getId() + " is not available");
            }
        }

        // 6. If yes, mark the status of all the seats as BLOCKED
        for(ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            // 7. Save the changes in the DB
            // save is an upsert(update + insert) operation
            showSeatRepository.save(showSeat);
        }


        //  8. Create a booking with PENDING status [save the Booking in DB]
        //  9. Return the Booking object
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setCreatedAt(new Date());
        booking.setUser(user);
        booking.setBookingNumber(UUID.randomUUID().toString());
        booking.setShow(show);
        booking.setShowSeats(showSeats);
        double amount = bookingAmountCalculator.calculateBookingAmount(show, showSeats);
        booking.setAmount(amount);
        return booking;
    }
}
