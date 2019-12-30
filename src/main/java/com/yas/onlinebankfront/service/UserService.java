package com.yas.onlinebankfront.service;

import java.util.List;

import com.yas.onlinebankfront.entities.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findUserList();
    void save (User user);
    User saveUser (User user);
    boolean checkUserExists(String username, String email);
    boolean checkUsernameExists(String username);
    boolean checkEmailExists(String email);
}