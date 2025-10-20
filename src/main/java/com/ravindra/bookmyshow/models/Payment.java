package com.ravindra.bookmyshow.models;

import com.ravindra.bookmyshow.models.enums.PaymentMode;
import com.ravindra.bookmyshow.models.enums.PaymentStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModal{
    private String referenceId;
    private PaymentMode paymentMode;
    private double amount;
    private PaymentStatus paymentStatus;
}
