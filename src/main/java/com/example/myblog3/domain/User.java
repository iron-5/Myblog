package com.example.myblog3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
//7
@Data
@NoArgsConstructor
public class User {
    private Long userId;
    private String userNickname;
    private String password;
    private String avatar;
    private Date createTime;
    private String email;
    private List<Blog> blogList;
}
