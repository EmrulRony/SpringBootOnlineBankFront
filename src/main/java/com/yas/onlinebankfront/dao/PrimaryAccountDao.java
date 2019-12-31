package com.yas.onlinebankfront.dao;

import com.yas.onlinebankfront.entities.PrimaryAccount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryAccountDao extends JpaRepository<PrimaryAccount, Long>{
    PrimaryAccount findByAccountNumber(int accountNumber);
}