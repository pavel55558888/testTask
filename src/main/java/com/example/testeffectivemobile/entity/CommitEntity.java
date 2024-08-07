package com.example.testeffectivemobile.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
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
    private long id_task;
    @Column(name = "author")
    @Schema(description = "Логин пользователя, который оставляет комментарий")
    private String login;
    @Column(name = "author")
    @Schema(description = "Комментарий")
    private String description;

    public CommitEntity(long id_task, String login, String description) {
        this.id_task = id_task;
        this.login = login;
        this.description = description;
    }
}
