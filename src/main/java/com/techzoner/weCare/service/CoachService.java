package com.techzoner.weCare.service;

import com.techzoner.weCare.dto.BookingDTO;
import com.techzoner.weCare.dto.CoachDTO;
import com.techzoner.weCare.exception.weCareException;

import java.util.List;

public interface CoachService {
    public CoachDTO addCoach(CoachDTO coachDTO);
    public Boolean coachLogins(String coachId,String coachPassword) throws weCareException;
    public CoachDTO getCoach(String coachId);
    public List<CoachDTO> getAllCoaches();
    public List<BookingDTO> getBookingByCoachId(String coachId);
}
