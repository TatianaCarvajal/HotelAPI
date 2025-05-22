package com.TatianaCarvajal.HotelAPI.repository;

import com.TatianaCarvajal.HotelAPI.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
