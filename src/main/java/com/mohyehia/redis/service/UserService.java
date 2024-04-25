package com.mohyehia.redis.service;

import com.mohyehia.redis.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findAll(String name);

    User findById(String userId);

    void update(String userId, User user);

    void delete(String userId);
}
