package com.example.testeffectivemobile.main_app.controller;

import com.example.testeffectivemobile.main_app.dto.DtoError;
import com.example.testeffectivemobile.main_app.dto.TaskAndCommitDto;
import com.example.testeffectivemobile.main_app.entity.CommitEntity;
import com.example.testeffectivemobile.main_app.entity.TaskEntity;
import com.example.testeffectivemobile.main_app.service.ServiceComment;
import com.example.testeffectivemobile.main_app.service.ServiceTask;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @Operation(summary = "Получить таски пользователей по логину/email", description = "Пользователь вводит логин/email в поле, после чего необходимо вставить его в url")
    @GetMapping("/tasks/{login}")
    public List<TaskEntity> getLogin(@PathVariable @Parameter(description = "Логин пользователя") String login){
        return serviceTask.getTaskLogin(login);
    }

    @Operation(summary = "Получить таску по id", description = "При нажатие на на одну из тасков нужно получить id, после чего в url его вставить")
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

    @Operation(summary = "Создать новый коммит", description = "Получите id открытой таски и отправте его в поле id_task со всеми данными," +
            "логин пользователя подставится авторматически")
    @PostMapping("/tasks/commit")
    public <T> T saveCommit(@Valid @RequestBody @Parameter(description = "Объект CommitEntity") CommitEntity commit, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            dtoError.setListError(bindingResult.getAllErrors());
            return (T) dtoError;
        }
        serviceComment.addComment(commit);
        return (T) "redirect:/api/task";
    }

    @Operation(summary = "Редактировать таску",description = "Для редактирования необходимо вызвать url \\\"/tasks/id/{id}\\\" \" +\n" +
            "            \"и вставить в поля ввода все необходимые данные, после чего при отправке post запросмом данные будут отредактированы")
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
