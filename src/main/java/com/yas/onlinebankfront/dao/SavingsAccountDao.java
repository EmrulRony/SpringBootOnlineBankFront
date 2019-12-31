package com.yas.onlinebankfront.dao;

import com.yas.onlinebankfront.entities.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsAccountDao extends JpaRepository<SavingsAccount, Long> {
    SavingsAccount findByAccountNumber(int accountNumber);
}