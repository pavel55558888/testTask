package com.example.testeffectivemobile.controller;

import com.example.testeffectivemobile.dto.DtoError;
import com.example.testeffectivemobile.dto.TaskAndCommitDto;
import com.example.testeffectivemobile.entity.CommitEntity;
import com.example.testeffectivemobile.entity.TaskEntity;
import com.example.testeffectivemobile.service.ServiceComment;
import com.example.testeffectivemobile.service.ServiceTask;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Контроллер главный")
@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    ServiceTask serviceTask;
    @Autowired
    ServiceComment serviceComment;
    @Autowired
    TaskAndCommitDto taskAndCommitDto;
    @Autowired
    DtoError dtoError;

    @Operation(summary = "Получить все таски")
    @GetMapping("/tasks")
    public List<TaskEntity> getAll(){
        return serviceTask.getAllTask();
    }

    @Operation(summary = "Получить таски пользователей по логину/email")
    @GetMapping("/tasks/{login}")
    public List<TaskEntity> getLogin(@PathVariable @Parameter(description = "Логин пользователя") String login){
        return serviceTask.getTaskLogin(login);
    }

    @Operation(summary = "Получить таску по id")
    @GetMapping("/tasks/id/{id}")
    public List<TaskAndCommitDto> getId(@PathVariable @Parameter(description = "id таски") long id){
        taskAndCommitDto.setTaskEntities(serviceTask.getTaskId(id));
        taskAndCommitDto.setCommitEntities(serviceComment.getCommentIdTask(id));
        List<TaskAndCommitDto> list = new ArrayList<>();
        list.add(taskAndCommitDto);
        return list;
    }

    @Operation(summary = "Удалить таску по id")
    @DeleteMapping("/tasks/{id}")
    public String delete(@PathVariable @Parameter(description = "id таски") long id){
        serviceTask.delete(id);
        return "redirect:/api/task";
    }

    @Operation(summary = "Создать новую таску")
    @PostMapping("/tasks")
    public <T> T saveTask(@RequestBody @Parameter(description = "Объект TaskEntity") @Valid TaskEntity task, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            dtoError.setListError(bindingResult.getAllErrors());
            return (T) dtoError;
        }
        serviceTask.saveTask(task);
        return (T) "redirect:/api/task";
    }

    @Operation(summary = "Создать новый коммит")
    @PostMapping("/tasks/commit")
    public <T> T saveCommit(@Valid @RequestBody @Parameter(description = "Объект CommitEntity") CommitEntity commit, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            dtoError.setListError(bindingResult.getAllErrors());
            return (T) dtoError;
        }
        serviceComment.addComment(commit);
        return (T) "redirect:/api/task";
    }

    @Operation(summary = "Редактировать таску")
    @PutMapping("/tasks")
    public <T> T updateTask(@Valid @RequestBody @Parameter(description = "Объект TaskEntity") TaskEntity task, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            dtoError.setListError(bindingResult.getAllErrors());
            return (T) dtoError;
        }
        serviceTask.saveTask(task);
        return (T) "redirect:/api/task";
    }

}
