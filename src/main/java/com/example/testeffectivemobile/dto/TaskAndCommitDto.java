package com.example.testeffectivemobile.dto;

import com.example.testeffectivemobile.entity.CommitEntity;
import com.example.testeffectivemobile.entity.TaskEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
