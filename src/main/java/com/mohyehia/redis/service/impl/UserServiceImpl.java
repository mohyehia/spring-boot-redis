package com.mohyehia.redis.service.impl;

import com.mohyehia.redis.entity.User;
import com.mohyehia.redis.service.UserService;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final HashOperations<String, String, User> hashOperations;

    public UserServiceImpl(RedisTemplate<String, User> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public User save(User user) {
        hashOperations.put("USER", user.getId(), user);
        return findById(user.getId());
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries("USER");
    }

    @Override
    public User findById(String userId) {
        return hashOperations.get("USER", userId);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public void delete(String userId) {
        hashOperations.delete("USER", userId);
    }
}
