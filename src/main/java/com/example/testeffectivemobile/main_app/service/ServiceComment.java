package com.example.testeffectivemobile.main_app.service;

import com.example.testeffectivemobile.main_app.entity.CommitEntity;

import java.util.List;

public interface ServiceComment {
    public List<CommitEntity> getCommentIdTask(long id);
    public void addComment(CommitEntity commit);
}
