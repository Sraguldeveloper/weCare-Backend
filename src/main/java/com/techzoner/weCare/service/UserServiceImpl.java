package com.techzoner.weCare.service;

import com.techzoner.weCare.dto.BookingDTO;
import com.techzoner.weCare.dto.CoachDTO;
import com.techzoner.weCare.dto.UserDTO;
import com.techzoner.weCare.exception.weCareException;
import com.techzoner.weCare.repository.BookingRepository;
import com.techzoner.weCare.repository.UserRepository;
import com.techzoner.weCare.utilites.Booking;
import com.techzoner.weCare.utilites.Coach;
import com.techzoner.weCare.utilites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepo;

    private UserServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    BookingRepository bookingRepository;

    @Override
    public UserDTO addUser(UserDTO userdto) {
        User user = userRepo.saveAndFlush(UserDTO.prepareUserEntity(userdto));
        return User.prepareUserDTO(user);
    }

    @Override
    public Boolean UserLogins(String userId, String coachPassword) throws weCareException {
        Optional<User> optionalUser = userRepo.findById(userId);
        if(!optionalUser.isPresent()){
            throw new weCareException("USER_NOT_FOUND");
        }
        User user = optionalUser.get();
        return user.getPassword().equals(coachPassword);
    }

    @Override
    public UserDTO getUserById(String userId) throws weCareException {
        Optional<User> optionalUser = userRepo.findById(userId);
        if(!optionalUser.isPresent()){
            throw new weCareException("USER_NOT_FOUND");
        }
        UserDTO userDto = User.prepareUserDTO(optionalUser.get());
        return userDto;
    }

    @Override
    public List<BookingDTO> getBookingByUserId(String userId) {
        List<Booking> bookings = bookingRepository.findByUserId(userId);
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
