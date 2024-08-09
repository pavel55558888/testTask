package com.example.testeffectivemobile.main_app.service.impl;

import com.example.testeffectivemobile.main_app.dao.DaoTask;
import com.example.testeffectivemobile.main_app.entity.TaskEntity;
import com.example.testeffectivemobile.main_app.service.ServiceTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceTaskImpl implements ServiceTask {
    @Autowired
    DaoTask daoTask;

    @Override
    public List<TaskEntity> getAllTask() {
        List<TaskEntity> allTask = daoTask.getAllTask();
        allTask = allTask.stream().sorted(Comparator.comparingDouble(TaskEntity::getPriority)).collect(Collectors.toList());
        return allTask;
    }

    @Override
    public List<TaskEntity> getTaskLogin(String login) {
        List<TaskEntity> taskLogin = daoTask.getTaskLogin(login);
        return taskLogin;
    }

    @Override
    public List<TaskEntity> getTaskId(Long id) {
        List<TaskEntity> taskId = daoTask.getTaskId(id);
        return taskId;
    }

    @Override
    public void delete(long id) {
        daoTask.delete(id);
    }

    @Override
    public void saveTask(TaskEntity task) {
        daoTask.saveTask(task);
    }
}
