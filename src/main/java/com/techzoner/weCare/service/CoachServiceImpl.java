package com.techzoner.weCare.service;

import com.techzoner.weCare.dto.BookingDTO;
import com.techzoner.weCare.dto.CoachDTO;
import com.techzoner.weCare.exception.weCareException;
import com.techzoner.weCare.repository.BookingRepository;
import com.techzoner.weCare.repository.CoachRepository;
import com.techzoner.weCare.utilites.Booking;
import com.techzoner.weCare.utilites.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "coach_service")
public class CoachServiceImpl implements CoachService{

    @Autowired
    CoachRepository coachRepo;

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public CoachDTO addCoach(CoachDTO coachDTO) {

        Coach coach = coachRepo.saveAndFlush(CoachDTO.prePareCoachEntity(coachDTO));
        return Coach.prepareCoachDTO(coach);
    }

    @Override
    public Boolean coachLogins(String coachId, String coachPassword) throws weCareException {
        Optional<Coach> optionalCoach = coachRepo.findById(coachId);
        if(!optionalCoach.isPresent()){
            throw new weCareException("COACH_NOT_FOUND");
        }
        Coach coach = optionalCoach.get();
        return coach.getPassword().equals(coachPassword);
    }

    @Override
    public CoachDTO getCoach(String coachId) {
        Optional<Coach> optionalCoach = coachRepo.findById(coachId);
        if(!optionalCoach.isPresent()){
            return null;
        }
        Coach coach = optionalCoach.get();
        return Coach.prepareCoachDTO(coach);
    }

    @Override
    public List<CoachDTO> getAllCoaches() {
        List<Coach> coachList = coachRepo.findAll();
        List<CoachDTO> coachDTO = new ArrayList<>();
        coachList.forEach((coach)->{
            coachDTO.add(Coach.prepareCoachDTO(coach));
        });
        return coachDTO;
    }

    @Override
    public List<BookingDTO> getBookingByCoachId(String coachId) {
        List<Booking> bookings = bookingRepository.findByCoachId(coachId);
        List<BookingDTO> bookingto = new ArrayList<>();
        for(Booking books:bookings){
            BookingDTO bookingdto = new BookingDTO();
            bookingdto.setCoachId(books.getCoachId());
            bookingdto.setSlot(books.getSlot());
            bookingdto.setAppointmentDate(books.getAppointmentDate());
            bookingdto.setUserId(books.getUserId());
            bookingto.add(bookingdto);
        }
        return bookingto;
    }
}
