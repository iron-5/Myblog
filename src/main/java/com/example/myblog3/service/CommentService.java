package com.example.myblog3.service;

import com.example.myblog3.domain.Blog;
import com.example.myblog3.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAllComments();
    int addComment(Comment comment, Blog blog);
}
