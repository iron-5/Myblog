package com.example.myblog3.mapper;

import com.example.myblog3.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUser(String nickname, String password);
}
