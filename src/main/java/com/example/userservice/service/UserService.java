package com.example.userservice.service;

import java.util.List;

import com.example.userservice.model.User;

public interface UserService {
	User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);

}
