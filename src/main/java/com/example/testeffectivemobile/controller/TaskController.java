package com.example.testeffectivemobile.controller;

import com.example.testeffectivemobile.dto.TaskAndCommitDto;
import com.example.testeffectivemobile.entity.TaskEntity;
import com.example.testeffectivemobile.service.ServiceComment;
import com.example.testeffectivemobile.service.ServiceTask;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/tasks/{id}")
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
    public String saveTask(@RequestBody @Parameter(description = "Объект TaskEntity") TaskEntity task){
        serviceTask.saveTask(task);
        return "redirect:/api/task";
    }

    @Operation(summary = "Редактировать таску")
    @PutMapping("/tasks")
    public String updateTask(@RequestBody @Parameter(description = "Объект TaskEntity") TaskEntity task){
        serviceTask.saveTask(task);
        return "redirect:/api/task";
    }

}
