package com.techzoner.weCare.controller;

import com.techzoner.weCare.dto.BookingDTO;
import com.techzoner.weCare.dto.CoachDTO;
import com.techzoner.weCare.dto.CoachLoginDTO;
import com.techzoner.weCare.exception.weCareException;
import com.techzoner.weCare.service.CoachService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.ReplicateScaleFilter;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/Coaches")
public class Coach {
    @Autowired
    CoachService coachService;
    @PostMapping(consumes = "application/json")
    public ResponseEntity<String>addCoach(@RequestBody CoachDTO coachDTO) throws weCareException {
        System.out.println(coachDTO.getGender());
        if (coachDTO.getPassword() == null || coachDTO.getPassword().length() < 5 || coachDTO.getPassword().length() > 10) {
            throw new weCareException("Password is invalid");
        }

        // Corrected name length check: less than 5 OR greater than 50
        if (coachDTO.getName() == null || coachDTO.getName().length() < 5 || coachDTO.getName().length() > 50) {
            throw new weCareException("Name is not valid");
        }

        // Corrected mobile number length check: NOT equal to 10
        if (coachDTO.getMobileNumber() == null || coachDTO.getMobileNumber().toString().length() != 10) {
            throw new weCareException("Invalid mobile number");
        }

        // Corrected speciality length check
        if (coachDTO.getSpeciality() == null || coachDTO.getSpeciality().length() < 3 || coachDTO.getSpeciality().length() > 50) {
            throw new weCareException("Invalid speciality");
        }
        CoachDTO newCoach = coachService.addCoach(coachDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCoach.getCoachId()+"Created successfully");
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Boolean> coachLogin(@RequestBody CoachLoginDTO loginDto) throws weCareException {
        Boolean isLoggedIn = coachService.coachLogins(loginDto.getCoachId(), loginDto.getPassword());
        return new ResponseEntity<>(isLoggedIn, HttpStatus.OK);
    }

    @GetMapping(path="/{coachId}")
    public ResponseEntity<CoachDTO> getCoach(@PathVariable(name="coachId")String coachId){
        CoachDTO coachdto = coachService.getCoach(coachId);
        return ResponseEntity.status(HttpStatus.FOUND).body(coachdto);
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<CoachDTO>> getAllCoaches(){
        List<CoachDTO> coachdto = coachService.getAllCoaches();
        return ResponseEntity.status(HttpStatus.FOUND).body(coachdto);
    }

    @GetMapping(path="/booking/{coachId}")
    public ResponseEntity<List<BookingDTO>> getBookingByCoachId(@PathVariable(name="coachId") String coachId){
        return ResponseEntity.status(HttpStatus.FOUND).body(coachService.getBookingByCoachId(coachId));
    }
}
