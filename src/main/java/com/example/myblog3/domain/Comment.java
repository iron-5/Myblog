package com.example.myblog3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Comment {
    private Long commentId;
    private String commentNickname;
    private String content;
    private String avatar;
    private Date createTime;
    private String email;
    private Comment parentComment;
    private List<Comment> childComment;
    private Blog blog;
}
