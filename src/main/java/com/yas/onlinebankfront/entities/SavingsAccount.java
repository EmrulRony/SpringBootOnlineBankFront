package com.yas.onlinebankfront.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "savings_account")
public class SavingsAccount extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "account_number")
    private long accountNumber;
    @Column(name= "account_balance")
    private BigDecimal accountBalance;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "savingsAccount")
    private List<SavingsTransaction> savingsTransactionList;

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<SavingsTransaction> getSavingsTransactionList() {
        return savingsTransactionList;
    }

    public void setSavingsTransactionList(List<SavingsTransaction> savingsTransactionList) {
        this.savingsTransactionList = savingsTransactionList;
    }

    @Override
    public String toString() {
        return "SavingsAccount [accountBalance=" + accountBalance + ", accountNumber=" + accountNumber + "]";
    }
    
}