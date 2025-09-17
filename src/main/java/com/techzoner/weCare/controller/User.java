package com.techzoner.weCare.controller;

import com.techzoner.weCare.dto.BookingDTO;
import com.techzoner.weCare.dto.CoachLoginDTO;
import com.techzoner.weCare.dto.UserDTO;
import com.techzoner.weCare.dto.UserLoginDTO;
import com.techzoner.weCare.exception.weCareException;
import com.techzoner.weCare.repository.UserRepository;
import com.techzoner.weCare.service.BookingService;
import com.techzoner.weCare.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class User {
    @Autowired
    UserService userService;

    @Autowired
    BookingService bookingService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> addUser(@RequestBody UserDTO userdto){
        UserDTO userDTO = userService.addUser(userdto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO.getUserId()+" Created successfully");
    }
    @PostMapping(path = "/login")
    public ResponseEntity<Boolean> userLogin(@RequestBody UserLoginDTO loginDto) throws weCareException {
        Boolean isLoggedIn = userService.UserLogins(loginDto.getUserId(), loginDto.getPassword());
        return new ResponseEntity<>(isLoggedIn, HttpStatus.OK);
    }
    @GetMapping(path="/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(name="userId")String userId) throws weCareException {
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getUserById(userId));
    }
    @PostMapping("/{userId}/booking/{coachId}")
    public ResponseEntity<Boolean> bookAnAppointment(@PathVariable(name = "userId")String userId, @PathVariable(name="coachId")String coachId, @RequestBody BookingDTO bookingdto) throws weCareException {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.bookAppointment(userId,coachId,bookingdto));
    }

    @GetMapping("/booking/{userId}")
    public ResponseEntity<List<BookingDTO>> getBookingByUserId(@PathVariable(name="userId") String userId){
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getBookingByUserId(userId));
    }
}
