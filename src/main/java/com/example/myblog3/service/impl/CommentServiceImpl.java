package com.example.myblog3.service.impl;

import com.example.myblog3.domain.Blog;
import com.example.myblog3.domain.Comment;
import com.example.myblog3.mapper.CommentMapper;
import com.example.myblog3.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> findAllComments() {
        List<Comment> comments = commentMapper.selectAllComments();

        return createNewList(comments);
    }

    @Override
    public int addComment(Comment comment, Blog blog) {
        comment.setBlog(blog);
        comment.setCreateTime(new Date());
        return commentMapper.saveComment(comment);
    }
    private  List<Comment> childList = new ArrayList<>();
    private List<Comment> createNewList(List<Comment> comments){
        for (Comment comment: comments
             ) {
            if(comment.getChildComment() != null){
                for (Comment c: comment.getChildComment()
                     ) {
                    if(comment.getChildComment() != null){
                        comment.setChildComment(findChildComment(c));
                        childList.clear();
                    }
                }
            }
        }
        return comments;
    }
    private List<Comment> findChildComment(Comment comment){
            childList.add(comment);
            if(comment.getChildComment().size()>0){
                List<Comment> children = comment.getChildComment();
                for (Comment child: children
                     ) {
                    childList.add(child);
                    if(child.getChildComment().size()>0)
                        findChildComment(child);
                }
            }
            return childList;
    }

}
