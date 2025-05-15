package com.TatianaCarvajal.HotelAPI.service;

import com.TatianaCarvajal.HotelAPI.model.Guest;
import com.TatianaCarvajal.HotelAPI.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    //Show guest
    public List<Guest> getAllGuest() {
      return guestRepository.findAll();
    }
    
    //Show guest by id
    public Optional<Guest> getGuestById(Long id) {
        return guestRepository.findById(id);
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
