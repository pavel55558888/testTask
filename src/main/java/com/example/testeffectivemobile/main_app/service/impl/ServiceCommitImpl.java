package com.example.testeffectivemobile.main_app.service.impl;

import com.example.testeffectivemobile.main_app.dao.impl.DaoCommentImpl;
import com.example.testeffectivemobile.main_app.entity.CommitEntity;
import com.example.testeffectivemobile.main_app.service.ServiceComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceCommitImpl implements ServiceComment {
    @Autowired
    DaoCommentImpl daoComment;
    @Override
    public List<CommitEntity> getCommentIdTask(long id) {
        return daoComment.getCommentIdTask(id);
    }

    @Override
    public void addComment(CommitEntity commit) {
        daoComment.addComment(commit);
    }
}
