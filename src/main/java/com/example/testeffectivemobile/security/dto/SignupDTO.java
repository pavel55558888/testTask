package com.example.testeffectivemobile.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class SignupDTO {
    @Schema(name = "Логин")
    @Pattern(regexp = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}",message = "Введите корректный email")
    private String email;
    @Schema(name = "Пароль")
    @Length(min=5,max=255,message = "Длинна пароля должна быть не менее 5 и не более 255")
    @NotBlank
    private String password;

}
