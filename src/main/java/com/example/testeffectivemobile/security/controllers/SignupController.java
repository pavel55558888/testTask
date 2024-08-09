package com.example.testeffectivemobile.security.controllers;

import com.example.testeffectivemobile.security.dto.SignupDTO;
import com.example.testeffectivemobile.security.dto.UserDTO;
import com.example.testeffectivemobile.security.services.auth.AuthService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Schema(name = "Класс регистрации")
@RestController
public class SignupController {

    @Autowired
    private AuthService authService;

    @Schema(name = "Создать новый аккаунт", description = "Необходимо отправить в теле запроса логин и пароль")
    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupDTO signupDTO) {
       UserDTO createdUser = authService.createUser(signupDTO);
       if (createdUser == null){
           return new ResponseEntity<>("Не получилось создать пользователя", HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

}
