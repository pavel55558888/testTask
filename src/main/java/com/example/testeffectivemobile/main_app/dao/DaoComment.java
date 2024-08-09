package com.example.testeffectivemobile.main_app.dao;

import com.example.testeffectivemobile.main_app.entity.CommitEntity;

import java.util.List;

public interface DaoComment {
    public List<CommitEntity> getCommentIdTask(long id);
    public void addComment(CommitEntity commit);
}
