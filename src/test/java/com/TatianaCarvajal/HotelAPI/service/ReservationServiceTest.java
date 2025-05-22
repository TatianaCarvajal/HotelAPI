package com.TatianaCarvajal.HotelAPI.service;

import com.TatianaCarvajal.HotelAPI.model.Reservation;
import com.TatianaCarvajal.HotelAPI.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    private Reservation reservation;

    @BeforeEach
    void setUpReservation() {
        reservation = new Reservation();
        reservation.setReservationId(4L);
        reservation.setCheckInDate("2025-08-16");
        reservation.setCheckOutDate("2025-08-20");
        reservation.setCost(370.00);
        reservation.setPaymentMethod("Credit card");
    }

    @Test
    void testFindAllReservationSuccess() {
        when(reservationRepository.findAll()).thenReturn(Arrays.asList(reservation));

        assertNotNull(reservationService.getAllReservation());
        assertEquals("2025-08-16", reservation.getCheckInDate());
    }

    @Test
    void testFindAllReservationFailure() {
        when(reservationRepository.findAll()).thenThrow(new RuntimeException("Error to find reservations"));

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            reservationService.getAllReservation();
        });

        assertEquals("Error to find reservations", ex.getMessage());
    }

    @Test
    void testFindReservationByIdSuccess() {
        when(reservationRepository.findById(reservation.getReservationId())).thenReturn(Optional.of(reservation));

        Optional<Reservation> reservationResult = reservationService.getReservationById(reservation.getReservationId());

        assertTrue(reservationResult.isPresent());
        assertEquals("2025-08-20", reservationResult.get().getCheckOutDate());
    }

    @Test
    void testFindReservationByIdFailure() {
        when(reservationRepository.findById(30L)).thenReturn(Optional.empty());

        Optional<Reservation> reservationResult = reservationService.getReservationById(30L);

        assertTrue(reservationResult.isEmpty(), "Reservation was no found with that id");
    }

    @Test
    void testCreateReservationSuccess() {
        when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);

        assertNotNull(reservationService.createReservation(new Reservation()));
    }

    @Test
    void testCreateReservationFailure() {
        when(reservationRepository.save(any(Reservation.class))).thenThrow(new RuntimeException("Error to save"));

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            reservationService.createReservation(new Reservation());
        });

        assertEquals("Error to save", ex.getMessage());
    }

    @Test
    void testUpdateReservationSuccess() {
        when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);

        assertNotNull(reservationService.updateReservation(reservation));
    }

    @Test
    void testUpdateReservationFailure() {
        when(reservationRepository.save(any(Reservation.class))).thenThrow(new RuntimeException("Error to update"));

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            reservationService.updateReservation(new Reservation());
        });

        assertEquals("Error to update", ex.getMessage());
    }

    @Test
    void testDeleteReservationSuccess() {
        reservationService.deleteReservation(reservation.getReservationId());

        verify(reservationRepository, times(1)).deleteById(reservation.getReservationId());
    }

    @Test
    void testDeleteReservationFailure() {
        doThrow(new RuntimeException("Fail to delete the reservation")).when(reservationRepository).deleteById(reservation.getReservationId());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            reservationService.deleteReservation(reservation.getReservationId());
        });

        assertEquals("Fail to delete the reservation", ex.getMessage());
    }
}
