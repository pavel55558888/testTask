package com.example.testeffectivemobile.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Модель таблицы базы данных, которая содержит таски")
@Table(name = "tasks")
@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Id, первичный ключ",accessMode = Schema.AccessMode.READ_ONLY)
    private long id;
    @Column(name = "header")
    @Schema(description = "Заголовок")
    private String header;
    @Column(name = "description")
    @Schema(description = "Описание")
    private String description;
    @Column(name = "status")
    @Schema(description = "Статус")
    private String status;
    @Column(name = "priority")
    @Schema(description = "Приоритет от меньшего к большему")
    private int priority;
    @Column(name = "author")
    @Schema(description = "Автор/логин пользователя", accessMode = Schema.AccessMode.READ_ONLY)
    private String author;
    @Column(name = "executor")
    @Schema(description = "Исполнитель/логин пользователя", accessMode = Schema.AccessMode.READ_ONLY)
    private String executor;

    public TaskEntity(String header, String description, String status, int priority, String author, String executor) {
        this.header = header;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.author = author;
        this.executor = executor;
    }

}
