package com.techzoner.weCare.controller;

import com.techzoner.weCare.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
