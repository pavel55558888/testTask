package com.example.testeffectivemobile.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SignupDTO {
    @Schema(name = "Логин")
    private String email;
    @Schema(name = "Пароль")
    private String password;

}
