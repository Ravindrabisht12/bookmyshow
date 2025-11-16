package com.ravindra.bookmyshow.controllers;

import com.ravindra.bookmyshow.dtos.CreateBookingRequestDto;
import com.ravindra.bookmyshow.dtos.CreateBookingResponseDto;
import com.ravindra.bookmyshow.dtos.ResponseStatus;
import com.ravindra.bookmyshow.models.Booking;
import com.ravindra.bookmyshow.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public CreateBookingResponseDto createBooking(CreateBookingRequestDto resquestDto) {
        CreateBookingResponseDto responseDto = new CreateBookingResponseDto();

        try{
            Booking booking = bookingService.createBooking(
                    resquestDto.getUserId(),
                    resquestDto.getShowSeatIds(),
                    resquestDto.getShowId()
            );

            responseDto.setBookingId(booking.getId());
            responseDto.setStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDto.setStatus(ResponseStatus.FAILED);
        }



        // Logic to handle booking creation
        return responseDto;
    }
}
