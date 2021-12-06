package com.sowmya.librarysystem.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
