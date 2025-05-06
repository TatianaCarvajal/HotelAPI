package com.TatianaCarvajal.HotelAPI.service;

import com.TatianaCarvajal.HotelAPI.model.Reservation;
import com.TatianaCarvajal.HotelAPI.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    //Show reservation
    private List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    //Create reservation
    private Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    //Update reservation
    private Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    //Delete reservation
    private void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
