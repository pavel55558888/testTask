package com.example.testeffectivemobile.service.impl;

import com.example.testeffectivemobile.dao.impl.DaoCommentImpl;
import com.example.testeffectivemobile.entity.CommitEntity;
import com.example.testeffectivemobile.service.ServiceComment;
import com.example.testeffectivemobile.service.ServiceTask;
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
