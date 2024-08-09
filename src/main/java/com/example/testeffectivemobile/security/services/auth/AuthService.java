package com.example.testeffectivemobile.security.services.auth;


import com.example.testeffectivemobile.security.dto.SignupDTO;
import com.example.testeffectivemobile.security.dto.UserDTO;

public interface AuthService {
    UserDTO createUser(SignupDTO signupDTO);
}
