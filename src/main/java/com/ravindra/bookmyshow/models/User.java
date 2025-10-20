package com.ravindra.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import javax.naming.Name;
import java.util.List;

@Getter
@Setter
@Entity(name="users")
public class User extends BaseModal{
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private List<Booking> bookings;
}
