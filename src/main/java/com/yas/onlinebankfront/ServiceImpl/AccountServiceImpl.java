package com.yas.onlinebankfront.ServiceImpl;

import java.math.BigDecimal;

import com.yas.onlinebankfront.dao.PrimaryAccountDao;
import com.yas.onlinebankfront.dao.SavingsAccountDao;
import com.yas.onlinebankfront.entities.PrimaryAccount;
import com.yas.onlinebankfront.entities.SavingsAccount;
import com.yas.onlinebankfront.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private static int accountNumber = 10000000;
    @Autowired
    PrimaryAccountDao primaryAccountDao;
    @Autowired
    SavingsAccountDao savingsAccountDao;

    @Override
    public PrimaryAccount createPrimaryAccount() {
        PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountNumber(accountNumberGenerator());
        primaryAccount.setAccountBalance(new BigDecimal(0.0));
        primaryAccountDao.save(primaryAccount);
        return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
    }

    @Override
    public SavingsAccount createSavingsAccount() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountNumber(accountNumberGenerator());
        savingsAccount.setAccountBalance(new BigDecimal(0.0));
        savingsAccountDao.save(savingsAccount);
        return savingsAccountDao.findByAccountNumber(savingsAccount.getAccountNumber());
    }

    private int accountNumberGenerator(){
        return ++accountNumber;
    } 
    
}