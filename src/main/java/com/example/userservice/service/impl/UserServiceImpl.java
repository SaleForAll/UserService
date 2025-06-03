package com.example.userservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userservice.Exception.UserNotFoundException;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long userId, User user) {
        User existing = getUserById(userId);
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setRole(user.getRole());
        return userRepository.save(existing);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
