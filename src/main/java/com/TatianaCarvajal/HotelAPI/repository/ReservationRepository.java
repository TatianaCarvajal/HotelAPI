package com.TatianaCarvajal.HotelAPI.repository;

import com.TatianaCarvajal.HotelAPI.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
