package com.yas.onlinebankfront.service;

import com.yas.onlinebankfront.entities.PrimaryAccount;
import com.yas.onlinebankfront.entities.SavingsAccount;

public interface AccountService {
    PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();
}