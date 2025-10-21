package com.ravindra.bookmyshow.models;


import com.ravindra.bookmyshow.models.enums.Feature;
import com.ravindra.bookmyshow.models.enums.Language;
import jakarta.persistence.*;
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

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Language> languages;
}


/**
 *
 *   1             M
 *  Movie ------- Features
 *   M               1
 */