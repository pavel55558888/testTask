package com.example.testeffectivemobile.dao.impl;

import com.example.testeffectivemobile.dao.DaoTask;
import com.example.testeffectivemobile.entity.TaskEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DaoTaskImpl implements DaoTask {

    @Override
    public List<TaskEntity> getAllTask() {
        List<TaskEntity> allTask;
        try(SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TaskEntity.class).buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();){
            session.beginTransaction();

            allTask = session.createQuery("from TaskEntity").getResultList();

            session.getTransaction().commit();
        }

        return allTask;
    }

    @Override
    public List<TaskEntity> getTaskLogin(String login) {
        List<TaskEntity> taskLogin;
        try(SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TaskEntity.class).buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();){
            session.beginTransaction();

            taskLogin = session.createQuery("from TaskEntity where executor = :param1").setParameter("param1", login).getResultList();

            session.getTransaction().commit();
        }
        return taskLogin;
    }

    @Override
    public List<TaskEntity> getTaskId(Long id) {
        List<TaskEntity> taskLogin;
        try(SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TaskEntity.class).buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();){
            session.beginTransaction();

            taskLogin = session.createQuery("from TaskEntity where id = :param1").setParameter("param1", id).getResultList();

            session.getTransaction().commit();
        }
        return taskLogin;
    }

    @Override
    public void delete(long id) {
        try(SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TaskEntity.class).buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();){
            session.beginTransaction();

            session.createQuery("delete TaskEntity where id = :param1").setParameter("param1", id).executeUpdate();

            session.getTransaction().commit();
        }
    }

    @Override
    public void saveTask(TaskEntity task) {
        try(SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TaskEntity.class).buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();){
            session.beginTransaction();

            session.saveOrUpdate(task);

            session.getTransaction().commit();
        }
    }
}
