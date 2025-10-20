package com.ravindra.bookmyshow.models;


import com.ravindra.bookmyshow.models.enums.Feature;
import com.ravindra.bookmyshow.models.enums.Language;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModal{
    private String name;
    private Date releaseDate;
    private List<Feature> features;
    private List<Language> languages;
}
