package com.example.testeffectivemobile.security.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "users")
@Data
@Schema(name = "Модель таблицы базы данных пользователей")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "id, первичный ключ")
    private Long id;
    @Schema(name = "Логин")
    private String email;
    @Schema(name = "Пароль")
    private String password;

}
