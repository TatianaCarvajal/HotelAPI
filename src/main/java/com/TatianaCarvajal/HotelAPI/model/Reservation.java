package com.TatianaCarvajal.HotelAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservationId;

    private String checkInDate;
    private String checkOutDate;
    private Double cost;
    @NotBlank(message = "Payment method is mandatory")
    private String paymentMethod;
}
