package com.leylaqa.bank;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BankAccountTest {

    private static final double DELTA = 0.001;

    @Test
    public void withdrawReducesBalanceByRequestedAmount() {
        BankAccount account = new BankAccount("Alex", 100.0);

        account.withdraw(40.0);

        Assert.assertEquals(account.getBalance(), 60.0, DELTA);
    }

    @Test
    public void withdrawMoreThanBalanceThrowsAndKeepsBalance() {
        BankAccount account = new BankAccount("Alex", 100.0);

        Assert.expectThrows(IllegalArgumentException.class, () -> account.withdraw(150.0));

        Assert.assertEquals(account.getBalance(), 100.0, DELTA);
    }

    @Test
    public void withdrawNegativeAmountThrowsAndKeepsBalance() {
        BankAccount account = new BankAccount("Alex", 100.0);

        Assert.expectThrows(IllegalArgumentException.class, () -> account.withdraw(-50.0));

        Assert.assertEquals(account.getBalance(), 100.0, DELTA);
    }
}