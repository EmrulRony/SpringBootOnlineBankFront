package com.yas.onlinebankfront.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PrimaryTransaction extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private Date date;
    private String description;
    private String type;
    private String status;
    private double amount;
    @Column(name = "available_balance")
    private BigDecimal availableBalance;
    @ManyToOne
    @JoinColumn(name = "primary_account_id")
    private PrimaryAccount primaryAccount;

    public PrimaryTransaction(){

    }

    public PrimaryTransaction(Date date, String description, String type, String status, double amount,
            BigDecimal availableBalance, PrimaryAccount primaryAccount) {
        this.date = date;
        this.description = description;
        this.type = type;
        this.status = status;
        this.amount = amount;
        this.availableBalance = availableBalance;
        this.primaryAccount = primaryAccount;
    }

    @Override
    public String toString() {
        return "PrimaryTransaction [amount=" + amount + ", availableBalance=" + availableBalance + ", date=" + date
                + ", description=" + description + ", primaryAccount=" + primaryAccount + ", status=" + status
                + ", type=" + type + "]";
    }

}