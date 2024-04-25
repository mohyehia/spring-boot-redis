package com.mohyehia.redis.service.impl;

import com.mohyehia.redis.entity.User;
import com.mohyehia.redis.repository.UserRepository;
import com.mohyehia.redis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setTimeToLive(600);
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll(String name) {
        List<User> users = new ArrayList<>();
        if (name == null || name.trim().isEmpty()) {
            userRepository.findAll().forEach(users::add);
        } else {
            users.addAll(userRepository.findByName(name));
        }
        return users;
    }

    @Override
    public User findById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void update(String userId, User user) {
        User retrievedUser = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User not found"));
        retrievedUser.setName(user.getName());
        retrievedUser.setSalary(user.getSalary());
        userRepository.save(retrievedUser);
    }

    @Override
    public void delete(String userId) {
        userRepository.deleteById(userId);
    }
}
