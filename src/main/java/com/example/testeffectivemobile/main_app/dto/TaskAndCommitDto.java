package com.example.testeffectivemobile.main_app.dto;

import com.example.testeffectivemobile.main_app.entity.CommitEntity;
import com.example.testeffectivemobile.main_app.entity.TaskEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@Component
@Schema(description = "DTO класс \"Таски и комментарии\"")
public class TaskAndCommitDto {
    @Schema(description = "Объект \"Таски\"")
    private List<TaskEntity> taskEntities;
    @Schema(description = "Объект \"Комментарии\"")
    private List<CommitEntity> commitEntities;
}
