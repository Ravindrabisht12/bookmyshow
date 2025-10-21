package com.ravindra.bookmyshow.models;

import com.ravindra.bookmyshow.models.enums.PaymentMode;
import com.ravindra.bookmyshow.models.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModal{
    private String referenceId;
    private PaymentMode paymentMode;
    private double amount;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
