package com.ravindra.bookmyshow.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingResponseDto {
    private long bookingId;
    private ResponseStatus status;
}
