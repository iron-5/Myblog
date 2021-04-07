package com.example.myblog3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
//14
@Data
@NoArgsConstructor
public class Blog {
    private Long blogId;
    private String title;
    private String blogContent;
    private String description;
    private String firstImg;
    private boolean isRecommended;
    private boolean isPublished;
    private Date updateTime;
    private Date createTime;
    private String flag;
    private User user;
    private Type type;
    private Integer viewCount;
    private List<Tag> tags;
    private String[] tagsId;
    private List<Comment> comments;

}
