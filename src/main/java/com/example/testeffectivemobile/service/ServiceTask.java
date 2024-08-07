package com.example.testeffectivemobile.service;

import com.example.testeffectivemobile.entity.TaskEntity;

import java.util.List;

public interface ServiceTask {
    public List<TaskEntity> getAllTask();
    public List<TaskEntity> getTaskLogin(String login);
    public List<TaskEntity> getTaskId(Long id);
    public void delete(long id);
    public void saveTask(TaskEntity task);
}
