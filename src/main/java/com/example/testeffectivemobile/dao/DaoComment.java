package com.example.testeffectivemobile.dao;

import com.example.testeffectivemobile.entity.CommitEntity;

import java.util.List;

public interface DaoComment {
    public List<CommitEntity> getCommentIdTask(long id);
    public void addComment(CommitEntity commit);
}
