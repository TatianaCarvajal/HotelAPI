package com.TatianaCarvajal.HotelAPI.controller;

import com.TatianaCarvajal.HotelAPI.model.Guest;
import com.TatianaCarvajal.HotelAPI.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    //GET
    @GetMapping
    public List<Guest> getAllGuest() {
        return guestService.getAllGuest();
    }

    //POST
    @PostMapping
    public Guest createGuest(@RequestBody Guest guest) {
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
