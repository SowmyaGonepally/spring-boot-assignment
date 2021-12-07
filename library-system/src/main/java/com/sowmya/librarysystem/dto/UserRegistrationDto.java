package com.sowmya.librarysystem.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserRegistrationDto {

    @NotNull(message = "is required")
    @Size(min = 2,message = "please specify at least two characters")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 2,message = "please specify at least two characters")
    private String lastName;

    @NotNull(message = "is required")
    @Size(min = 5,message = "please specify at least 5 characters")
    private String username;

     @NotNull(message = "is required")
    @Size(min = 6,message = "Weak password..please specify at least 6 characters")
    private String password;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

}
