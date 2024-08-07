package com.example.testeffectivemobile.service;

import com.example.testeffectivemobile.entity.CommitEntity;

import java.util.List;

public interface ServiceComment {
    public List<CommitEntity> getCommentIdTask(long id);
    public void addComment(CommitEntity commit);
}
