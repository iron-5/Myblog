package com.example.myblog3.mapper;

import com.example.myblog3.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> selectAllComments();
    int saveComment(Comment comment);
    List<Comment> selectChildComment(Comment comment);

}
