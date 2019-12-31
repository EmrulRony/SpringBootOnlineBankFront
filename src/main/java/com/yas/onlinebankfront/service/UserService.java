package com.yas.onlinebankfront.service;

import java.util.List;
import java.util.Set;

import com.yas.onlinebankfront.entities.User;
import com.yas.onlinebankfront.entities.security.UserRole;

public interface UserService {
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findUserList();
    void save (User user);
    User saveUser (User user);
    boolean checkUserExists(String username, String email);
    boolean checkUsernameExists(String username);
    boolean checkEmailExists(String email);
    User createUser(User user, Set<UserRole> userRoles);
}