package com.ravindra.bookmyshow.models;

import com.ravindra.bookmyshow.models.enums.Feature;
import com.ravindra.bookmyshow.models.enums.Language;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModal{
    private String showTime;
    private Movie movie;
    private Screen screen;
    private Language language;
    private List<Feature> features;
}
