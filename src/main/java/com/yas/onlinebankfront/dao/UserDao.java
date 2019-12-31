package com.yas.onlinebankfront.dao;

import com.yas.onlinebankfront.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long>{
    User findByUsername(String username);
    User findByEmail(String email);
    User save(User user);
}