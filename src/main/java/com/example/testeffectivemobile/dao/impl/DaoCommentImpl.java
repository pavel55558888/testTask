package com.example.testeffectivemobile.dao.impl;

import com.example.testeffectivemobile.dao.DaoComment;
import com.example.testeffectivemobile.entity.CommitEntity;
import com.example.testeffectivemobile.entity.TaskEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DaoCommentImpl implements DaoComment {
    @Override
    public List<CommitEntity> getCommentIdTask(long id) {
        List<CommitEntity> commitEntities;
        try(SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CommitEntity.class).buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();){
            session.beginTransaction();

            commitEntities = session.createQuery("from CommitEntity where id_task = :param1").setParameter("param1", id).getResultList();

            session.getTransaction().commit();
        }
        return commitEntities;
    }

    @Override
    public void addComment(CommitEntity commit) {
        try(SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CommitEntity.class).buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();){
            session.beginTransaction();

            session.persist(commit);

            session.getTransaction().commit();
        }
    }
}
