package com.techzoner.weCare.service;

import com.techzoner.weCare.dto.BookingDTO;
import com.techzoner.weCare.dto.CoachDTO;
import com.techzoner.weCare.dto.UserDTO;
import com.techzoner.weCare.exception.weCareException;

import java.util.List;

public interface UserService {
    public UserDTO addUser(UserDTO userdto);
    public Boolean UserLogins(String coachId,String coachPassword) throws weCareException;
    public UserDTO getUserById(String userId) throws weCareException;
    public List<BookingDTO> getBookingByUserId(String userId);
}
