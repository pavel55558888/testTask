package com.example.testeffectivemobile.dao.impl;

import com.example.testeffectivemobile.dao.DaoTask;
import com.example.testeffectivemobile.entity.TaskEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class DaoTaskImpl implements DaoTask {
    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<TaskEntity> getAllTask() {
        Query query = entityManager.createQuery("from TaskEntity");
        return (List<TaskEntity>) query.getResultList();
    }

    @Override
    @Transactional
    public List<TaskEntity> getTaskLogin(String login) {
        Query query = entityManager.createQuery("from TaskEntity where executor = :param1").setParameter("param1", login);
        return (List<TaskEntity>) query.getResultList();
    }

    @Override
    @Transactional
    public List<TaskEntity> getTaskId(Long id) {
        Query query = entityManager.createQuery("from TaskEntity where id = :param1").setParameter("param1", id);
        return (List<TaskEntity>) query.getResultList();
    }

    @Override
    @Transactional
    public void delete(long id) {
        entityManager.createQuery("delete TaskEntity where id = :param1").setParameter("param1", id).executeUpdate();
    }

    @Override
    @Transactional
    public void saveTask(TaskEntity task) {
        TaskEntity taskEntity = entityManager.merge(task);
        task.setId(taskEntity.getId());
    }
}
