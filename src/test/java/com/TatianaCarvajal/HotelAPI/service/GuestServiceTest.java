package com.TatianaCarvajal.HotelAPI.service;

import com.TatianaCarvajal.HotelAPI.model.Guest;
import com.TatianaCarvajal.HotelAPI.repository.GuestRepository;
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
public class GuestServiceTest {

    @Mock
    private GuestRepository guestRepository;

    @InjectMocks
    private GuestService guestService;

    private Guest guest;

    @BeforeEach
    void setUpGuest() {
        guest = new Guest();
        guest.setGuestId(2L);
        guest.setName("Lucia");
        guest.setLastName("Galeano");
        guest.setNationality("French");
        guest.setBirthdate("30-04-1995");
        guest.setPhone("830-695-263");
    }

    @Test
    void testFindAllGuestSuccess() {
        when(guestRepository.findAll()).thenReturn(Arrays.asList(guest));

        assertNotNull(guestService.getAllGuest());
        assertEquals("Lucia", guest.getName());
    }

    @Test
    void testFindAllGuestFailure() {
        when(guestRepository.findAll()).thenThrow(new RuntimeException("Error to find guests"));

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            guestService.getAllGuest();
        });

        assertEquals("Error to find guests", ex.getMessage());
    }

    @Test
    void testFindGuestByIdSuccess() {
         when(guestRepository.findById(guest.getGuestId())).thenReturn(Optional.of(guest));

        Optional<Guest> guestResult = guestService.getGuestById(guest.getGuestId());

        assertTrue(guestResult.isPresent());
        assertEquals("Lucia", guestResult.get().getName());
    }

    @Test
    void testFindGuestByIdFailure() {
        when(guestRepository.findById(27L)).thenReturn(Optional.empty());

        Optional<Guest> guestResult = guestService.getGuestById(27L);

        assertTrue(guestResult.isEmpty(), "Guest was not found with that id");
    }

    @Test
    void testCreateGuestSuccess() {
        when(guestRepository.save(any(Guest.class))).thenReturn(guest);

        assertNotNull(guestService.createGuest(new Guest()));
    }

    @Test
    void testCreateGuestFailure() {
        when(guestRepository.save(any(Guest.class))).thenThrow(new RuntimeException("Error to save"));

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            guestService.createGuest(new Guest());
        });

        assertEquals("Error to save", ex.getMessage());
    }

    @Test
    void testUpdateGuestSuccess() {
        when(guestRepository.save(any(Guest.class))).thenReturn(guest);

        assertNotNull(guestService.updateGuest(guest));
    }

    @Test
    void testUpdateGuestFailure() {
        when(guestRepository.save(any(Guest.class))).thenThrow(new RuntimeException("Error to update"));

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            guestService.updateGuest(new Guest());
        });

        assertEquals("Error to update", ex.getMessage());
    }

    @Test
    void testDeleteGuestSuccess() {
        guestService.deleteGuest(guest.getGuestId());

        verify(guestRepository, times(1)).deleteById(2L);
    }

    @Test
    void testDeleteGuestFailure() {
        doThrow(new RuntimeException("Fail to delete the guest"))
                .when(guestRepository).deleteById(guest.getGuestId());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            guestService.deleteGuest(guest.getGuestId());
        });

        assertEquals("Fail to delete the guest", ex.getMessage());
    }
}
