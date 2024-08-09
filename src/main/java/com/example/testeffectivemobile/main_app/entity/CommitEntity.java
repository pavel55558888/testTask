package com.example.testeffectivemobile.main_app.entity;

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
    @Schema(description = "Id, первичный ключ",accessMode = Schema.AccessMode.READ_ONLY)
    private long id;
    @Column(name = "id_task")
    @Schema(description = "Id, первичный ключ объекта taskEntity",accessMode = Schema.AccessMode.READ_ONLY)
    @Min(value = 1, message = "Неверный id")
    private long id_task;
    @Column(name = "author")
    @Schema(description = "Логин пользователя, который оставляет комментарий", accessMode = Schema.AccessMode.READ_ONLY)
    private String login;
    @Column(name = "description")
    @Schema(description = "Комментарий")
    @Size(max = 255, message = "Комментарий слишком большой")
    @NotBlank(message = "Комментарий не может быть пустым")
    private String description;

    public CommitEntity(long id_task, String login, String description) {
        this.id_task = id_task;
        this.login = login;
        this.description = description;
    }
}
