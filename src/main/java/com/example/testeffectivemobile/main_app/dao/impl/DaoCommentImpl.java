package com.example.testeffectivemobile.main_app.dao.impl;

import com.example.testeffectivemobile.main_app.dao.DaoComment;
import com.example.testeffectivemobile.main_app.entity.CommitEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class DaoCommentImpl implements DaoComment {
    @Autowired
    EntityManager entityManager;
    @Override
    @Transactional
    public List<CommitEntity> getCommentIdTask(long id) {
        Query query = entityManager.createQuery("from CommitEntity where id_task = :param1").setParameter("param1", id);
        return (List<CommitEntity>) query.getResultList();
    }

    @Override
    @Transactional
    public void addComment(CommitEntity commit) {
        entityManager.merge(commit);
    }
}
