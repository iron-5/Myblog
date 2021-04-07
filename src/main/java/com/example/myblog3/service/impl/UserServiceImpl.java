package com.example.myblog3.service.impl;

import com.example.myblog3.domain.User;
import com.example.myblog3.mapper.UserMapper;
import com.example.myblog3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUser(String nickname, String password) {
        return userMapper.getUser(nickname, password);
    }
}
