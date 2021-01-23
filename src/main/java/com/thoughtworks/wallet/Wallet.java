package com.thoughtworks.wallet;

public class Wallet {
    public int totalBalance;

    public Wallet(int initialMoney) {
        this.totalBalance = initialMoney;
    }

    public void addMoney(Money money) {
        this.totalBalance += money.amount;
    }
}
