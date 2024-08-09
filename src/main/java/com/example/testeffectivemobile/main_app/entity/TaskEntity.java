package com.example.testeffectivemobile.main_app.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


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
    @Size(min = 5, message = "Заголов слишком маленький")
    @Size(max = 225, message = "Заголовок слишком большой")
    private String header;
    @Column(name = "description")
    @Schema(description = "Описание")
    @Size(min = 5, message = "Описание слишком маленькое")
    @Size(max = 225, message = "Описание слишком большое")
    private String description;
    @Column(name = "status")
    @Schema(description = "Статус")
    @NotBlank(message = "Поле не может быть пустым. Ожидает/В процессе/Закрыта")
    private String status;
    @Column(name = "priority")
    @Schema(description = "Приоритет, от меньшего(1) к большему(10)")
    @Min(1)
    @Max(10)
    private int priority;
    @Column(name = "author")
    @Schema(description = "Автор/логин пользователя", accessMode = Schema.AccessMode.READ_ONLY)
    @Pattern(regexp = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}",message = "Введите корректный email")
    private String author;
    @Column(name = "executor")
    @Schema(description = "Исполнитель/логин пользователя", accessMode = Schema.AccessMode.READ_ONLY)
    @Pattern(regexp = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}",message = "Введите корректный email")
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
