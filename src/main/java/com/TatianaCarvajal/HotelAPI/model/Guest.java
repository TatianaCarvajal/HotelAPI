package com.TatianaCarvajal.HotelAPI.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guestId;

    private String name;
    private String lastName;
    private String birthdate;
    private String nationality;
    private String phone;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();
}
