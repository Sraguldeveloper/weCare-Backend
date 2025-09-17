package com.techzoner.weCare.utilites;


import com.techzoner.weCare.dto.CoachDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Coach {
    @Id
    @Column(name="coach_id",unique = true)
    private String coachId;
    private String name;
    private String gender;
    @Column(name="date_of_birth")

    private LocalDate dateOfBirth;

    private String password;
    @Column(name="mobile_number")
    private Long mobileNumber;

    private String speciality;

    public static CoachDTO prepareCoachDTO(Coach coach){
        CoachDTO coachdto = new CoachDTO();
        coachdto.setCoachId(coach.getCoachId());
        coachdto.setName(coach.getName());
        coachdto.setSpeciality(coach.getSpeciality());
        coachdto.setMobileNumber(coach.getMobileNumber());
        coachdto.setDateOfBirth(coach.getDateOfBirth());
        coachdto.setSpeciality(coach.getSpeciality());
        coachdto.setGender(coach.getGender());
        return coachdto;
    }
}
