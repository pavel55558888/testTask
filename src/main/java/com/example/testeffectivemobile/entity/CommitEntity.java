package com.example.testeffectivemobile.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Таблица базы данных комментраиев")
@Entity
@Table(name = "commits")
public class CommitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "id")
    private long id;
    @Column(name = "id_task")
    @Schema(description = "id таски")
    @Min(1)
    private long id_task;
    @Column(name = "author")
    @Schema(description = "Логин пользователя, который оставляет комментарий")
    @Pattern(regexp = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}", message = "Введите корректный email")
    private String login;
    @Column(name = "description")
    @Schema(description = "Комментарий")
    @Size(max = 255, message = "Комментарий слишком большой")
    @NotBlank
    private String description;

    public CommitEntity(long id_task, String login, String description) {
        this.id_task = id_task;
        this.login = login;
        this.description = description;
    }
}
