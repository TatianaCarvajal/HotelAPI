package com.TatianaCarvajal.HotelAPI.service;

import com.TatianaCarvajal.HotelAPI.model.Guest;
import com.TatianaCarvajal.HotelAPI.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    //Show guest
    public List<Guest> getAllGuest() {
      return guestRepository.findAll();
    }

    //Create guest
    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    //Update guest
    public Guest updateGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    //Delete guest
    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }
}
