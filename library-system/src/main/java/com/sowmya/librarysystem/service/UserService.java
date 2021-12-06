package com.sowmya.librarysystem.service;

import com.sowmya.librarysystem.dto.UserRegistrationDto;
import com.sowmya.librarysystem.users.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto userRegistrationDto);


}
