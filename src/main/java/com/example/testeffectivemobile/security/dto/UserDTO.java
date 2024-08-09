package com.example.testeffectivemobile.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserDTO {
    @Schema(name = "Логин")
    private Long id;
    @Schema(name = "Пароль")
    private String email;

}
