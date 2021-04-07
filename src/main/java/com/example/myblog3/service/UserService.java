package com.example.myblog3.service;

import com.example.myblog3.domain.User;

public interface UserService {
    User findUser(String nickname, String password);
}
