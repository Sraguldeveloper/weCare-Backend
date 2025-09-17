package com.techzoner.weCare.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.techzoner.weCare.utilites.User;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class UserDTO {
    private String userId;

    private String name;
    private String gender;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
    private LocalDate dateOfBirth;
    private String password;
    @Column(name="mobile_number")
    private Long mobileNumber;

    private String email;
    private Integer pinCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String city;
    private String state;
    private String country;

    public static User prepareUserEntity(UserDTO userdto){
        User user = new User();
        user.setUserId(userdto.getUserId());
        user.setName(userdto.getName());
        user.setGender(userdto.getGender());
        user.setDateOfBirth(userdto.getDateOfBirth());
        user.setPassword(userdto.getPassword());
        user.setMobileNumber(userdto.getMobileNumber());
        user.setEmail(userdto.getEmail());
        user.setPinCode(userdto.getPinCode());
        user.setCity(userdto.getCity());
        user.setState(userdto.getState());
        user.setCountry(userdto.getCountry());
        return user;
    }
}
