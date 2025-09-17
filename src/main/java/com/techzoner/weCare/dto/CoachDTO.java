package com.techzoner.weCare.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.techzoner.weCare.utilites.Coach;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class CoachDTO {
    private String coachId;
    private String name;
    private String gender;

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
    private LocalDate dateOfBirth;

    private String password;
    private Long mobileNumber;

    private String speciality;

    public static Coach prePareCoachEntity(CoachDTO coachDTO){
        Coach coachEntity = new Coach();
        coachEntity.setCoachId(coachDTO.getCoachId());
        coachEntity.setName(coachDTO.getName());
        coachEntity.setPassword(coachDTO.getPassword());
        coachEntity.setSpeciality(coachDTO.getSpeciality());
        coachEntity.setMobileNumber(coachDTO.getMobileNumber());
        coachEntity.setDateOfBirth(coachDTO.getDateOfBirth());
        coachEntity.setSpeciality(coachDTO.getSpeciality());
        coachEntity.setGender(coachDTO.getGender());
        return coachEntity;
    }
}
