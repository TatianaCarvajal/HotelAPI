package com.TatianaCarvajal.HotelAPI.controller;

import com.TatianaCarvajal.HotelAPI.exception.ResourceNotFoundException;
import com.TatianaCarvajal.HotelAPI.model.Reservation;
import com.TatianaCarvajal.HotelAPI.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    //GET
    @GetMapping
    public List<Reservation> getAllReservation() throws ResourceNotFoundException {
        List<Reservation> reservations = reservationService.getAllReservation();
        if (reservations.isEmpty()) {
            throw new ResourceNotFoundException("No reservations found");
        }
        return reservations;
    }

    //GET
    @GetMapping("find/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        if (reservation.isEmpty()) {
            throw new ResourceNotFoundException("No reservation was found with that ID");
        }
        return reservation;
    }

    // POST
    @PostMapping
    public Reservation createReservation(@Valid @RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    //PUT
    @PutMapping("update/{id}")
    public Reservation updateReservation(@RequestBody Reservation reservation, @PathVariable Long id) {
        reservation.setReservationId(id);
        return reservationService.updateReservation(reservation);
    }

    //DELETE
    @DeleteMapping("delete/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
