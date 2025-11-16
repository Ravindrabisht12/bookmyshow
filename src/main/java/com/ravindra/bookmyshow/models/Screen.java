package com.ravindra.bookmyshow.models;

import com.ravindra.bookmyshow.models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModal{
    private String name;
    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}


/**
 *
 *
 * Screen has a One-to-Many relationship with Seat.
 *
 *   1              M
 * Screen ------- Seat 1:M
 *   1              1
 *
 *  1              M
 * Screen ------- Feature 1:M
 *  M              1
 */