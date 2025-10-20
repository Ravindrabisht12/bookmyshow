package com.ravindra.bookmyshow.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@MappedSuperclass
public class BaseModal {
    @Id // Private Key for all the models
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date createdAt;
    private Date lastModifiedAt;
}
