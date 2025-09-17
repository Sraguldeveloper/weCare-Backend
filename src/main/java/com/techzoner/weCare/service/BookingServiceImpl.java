package com.techzoner.weCare.service;

import com.techzoner.weCare.dto.BookingDTO;
import com.techzoner.weCare.exception.weCareException;
import com.techzoner.weCare.repository.BookingRepository;
import com.techzoner.weCare.repository.CoachRepository;
import com.techzoner.weCare.repository.UserRepository;
import com.techzoner.weCare.utilites.Booking;
import com.techzoner.weCare.utilites.Coach;
import com.techzoner.weCare.utilites.User;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{
    BookingRepository bookingRepo;
    CoachRepository coachRepo;
    UserRepository userRepo;
    private BookingServiceImpl(BookingRepository bookingRepo,CoachRepository coachRepo,UserRepository userRepo){
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
        this.coachRepo = coachRepo;
    }
    @Override
    public Boolean bookAppointment(String userId, String coachId, BookingDTO bookingDto) throws weCareException {
        Optional<User> findUserById = userRepo.findById(userId);
        Optional<Coach> findCoachById = coachRepo.findById(coachId);
        if(!findUserById.isPresent() ||!findCoachById.isPresent()){
            throw new weCareException("NOT_FOUND");
        }
        Booking booking = new Booking();
        booking.setCoachId(bookingDto.getCoachId());
        booking.setAppointmentDate(bookingDto.getAppointmentDate());
        booking.setUserId(bookingDto.getUserId());
        booking.setSlot(bookingDto.getSlot());
        Integer bookingId = bookingRepo.saveAndFlush(booking).getBookingId();
        if(bookingId!=null){
            return true;
        }
        return false;
    }

    @Override
    public void deleteBooking(Integer bookingId) {
        bookingRepo.deleteById(bookingId);
    }
}
