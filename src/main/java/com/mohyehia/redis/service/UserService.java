package com.mohyehia.redis.service;

import com.mohyehia.redis.entity.User;

import java.util.Map;

public interface UserService {
    User save(User user);
    Map<String, User> findAll();
    User findById(String userId);
    void update(User user);
    void delete(String userId);
}
