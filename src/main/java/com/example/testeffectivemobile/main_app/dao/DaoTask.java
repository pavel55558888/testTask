package com.example.testeffectivemobile.main_app.dao;

import com.example.testeffectivemobile.main_app.entity.TaskEntity;

import java.util.List;

public interface DaoTask {
    public List<TaskEntity> getAllTask();
    public List<TaskEntity> getTaskLogin(String login);
    public List<TaskEntity> getTaskId(Long id);
    public void delete(long id);
    public void saveTask(TaskEntity task);
}
