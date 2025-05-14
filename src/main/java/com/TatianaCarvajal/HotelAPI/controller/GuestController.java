package com.TatianaCarvajal.HotelAPI.controller;

import com.TatianaCarvajal.HotelAPI.exception.GuestNotFoundException;
import com.TatianaCarvajal.HotelAPI.model.Guest;
import com.TatianaCarvajal.HotelAPI.service.GuestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    //GET
    @GetMapping
    public List<Guest> getAllGuest() throws GuestNotFoundException {
        List<Guest> guests = guestService.getAllGuest();
        if (guests.isEmpty()) {
            throw new GuestNotFoundException("No guests found");
        }
        return guests;
    }

    //GET
    @GetMapping("find/{id}")
    public Optional<Guest> getGuestById(@PathVariable Long id) throws GuestNotFoundException {
        Optional<Guest> guest = guestService.getGuestById(id);
        if (guest.isEmpty()) {
            throw new GuestNotFoundException("No guest was found with that ID");
        }
        return guest;
    }

    //POST
    @PostMapping
    public Guest createGuest(@Valid @RequestBody Guest guest) {
        return guestService.createGuest(guest);
    }

    //PUT
    @PostMapping("update/{id}")
      public Guest updateGuest(@RequestBody Guest guest, @PathVariable Long id) {
        guest.setGuestId(id);
        return guestService.updateGuest(guest);
    }

    //DELETE
    @DeleteMapping("delete/{id}")
    public void deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
    }
}
