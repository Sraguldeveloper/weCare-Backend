package com.techzoner.weCare.controller;

import com.techzoner.weCare.dto.BookingUpdateDTO;
import com.techzoner.weCare.exception.weCareException;
import com.techzoner.weCare.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class Booking {
    @Autowired
    BookingService bookingService;

    @DeleteMapping(path="/{bookingId}")
    public ResponseEntity<?> deleteBooking(@PathVariable(name="bookingId")Integer bookingId){
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.ok("Successfully deleted");
    }
    @PatchMapping("/{bookingId}")
    public ResponseEntity<Boolean> rescheduleBooking(@PathVariable(value = "bookingId")Integer bookingId, @RequestBody BookingUpdateDTO bookingUpdatedto) throws weCareException {
        return ResponseEntity.ok(bookingService.rescheduleBooking(bookingId,bookingUpdatedto));
    }
}
