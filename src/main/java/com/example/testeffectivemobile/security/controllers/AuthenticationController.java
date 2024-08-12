package com.example.testeffectivemobile.security.controllers;


import com.example.testeffectivemobile.main_app.dto.DtoError;
import com.example.testeffectivemobile.security.dto.AuthenticationDTO;
import com.example.testeffectivemobile.security.dto.AuthenticationResponse;
import com.example.testeffectivemobile.security.services.jwt.UserDetailsServiceImpl;
import com.example.testeffectivemobile.security.util.JwtUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@Schema(name = "Класс авторизации")
@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    DtoError dtoError;
    @Schema(name = "Авторизация", description = "Необходимо в теле запроса отправить логин и пароль")
    @PostMapping("/authenticate")
    public <T> T createAuthenticationToken(@Valid @RequestBody AuthenticationDTO authenticationDTO, BindingResult bindingResult, HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {
        if (bindingResult.hasErrors()){
            dtoError.setListError(bindingResult.getAllErrors());
            return (T) dtoError;
        }

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getEmail(), authenticationDTO.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Неверные данные");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Пользователь не найден");
            return null;
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDTO.getEmail());

        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return (T) new AuthenticationResponse(jwt);

    }

}
