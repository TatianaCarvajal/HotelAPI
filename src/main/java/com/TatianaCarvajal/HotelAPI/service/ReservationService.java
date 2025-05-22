package com.TatianaCarvajal.HotelAPI.service;

import com.TatianaCarvajal.HotelAPI.model.Reservation;
import com.TatianaCarvajal.HotelAPI.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    //Show reservation
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    //Show reservation by id
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    //Create reservation
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    //Update reservation
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    //Delete reservation
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
