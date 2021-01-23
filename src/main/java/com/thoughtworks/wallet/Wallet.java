package com.thoughtworks.wallet;

public class Wallet {
    public int totalBalance;

    public Wallet(int initialMoney) {
        this.totalBalance = initialMoney;
    }

    public void addAmount(Money money) {
        this.totalBalance += money.amount;
    }

    public void takeAmount(Money money) { this.totalBalance -= money.amount;
    }
}
