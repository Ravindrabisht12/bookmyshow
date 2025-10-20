package com.ravindra.bookmyshow.models;

import com.ravindra.bookmyshow.models.enums.Feature;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModal{
    private String name;
    private List<Seat> seats;
    private List<Feature> features;
}
