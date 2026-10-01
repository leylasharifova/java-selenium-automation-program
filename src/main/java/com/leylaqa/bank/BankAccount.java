package com.leylaqa.bank;

public class BankAccount {
    private double balance;
    private String owner;

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive!");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        // BUG: Does not check for negative amounts!
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds!");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}