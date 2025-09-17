package com.techzoner.weCare.utilites;

import com.techzoner.weCare.dto.UserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User{
    @Id
    @Column(name="user_id",nullable = false,unique = true)
    private String userId;

    private String name;
    private String gender;
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;
    private String password;
    @Column(name="mobile_number")
    private Long mobileNumber;

    private String email;
    private Integer pinCode;
    private String city;
    private String state;
    private String country;

    public static UserDTO prepareUserDTO(User user){
        UserDTO userdto = new UserDTO();
        userdto.setUserId(user.getUserId());
        userdto.setName(user.getName());
        userdto.setGender(user.getGender());
        userdto.setDateOfBirth(user.getDateOfBirth());
        userdto.setPassword(user.getPassword());
        userdto.setMobileNumber(user.getMobileNumber());
        userdto.setEmail(user.getEmail());
        userdto.setPinCode(user.getPinCode());
        userdto.setCity(user.getCity());
        userdto.setCountry(user.getCountry());
        userdto.setState(user.getState());
        return userdto;
    }
}