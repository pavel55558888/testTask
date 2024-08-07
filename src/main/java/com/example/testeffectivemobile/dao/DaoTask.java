package com.example.testeffectivemobile.dao;

import com.example.testeffectivemobile.entity.TaskEntity;

import java.util.List;

public interface DaoTask {
    public List<TaskEntity> getAllTask();
    public List<TaskEntity> getTaskLogin(String login);
    public List<TaskEntity> getTaskId(Long id);
    public void delete(long id);
    public void saveTask(TaskEntity task);
}
