package com.yas.onlinebankfront.dao;

import com.yas.onlinebankfront.entities.security.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Long>{
    Role findByName(String name);
}