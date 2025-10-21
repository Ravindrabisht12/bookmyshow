package com.ravindra.bookmyshow.models;

import com.ravindra.bookmyshow.models.enums.Feature;
import com.ravindra.bookmyshow.models.enums.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="shows")
public class Show extends BaseModal{
    private String showTime;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;
    @Enumerated(EnumType.ORDINAL)
    private Language language;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
