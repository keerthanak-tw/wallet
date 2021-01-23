package com.thoughtworks.wallet;

public class Wallet {
    public int dollarAmount;
    public int rupeeAmount;

//    public Wallet(int initialMoney) {
//        this.totalBalance = initialMoney;
//    }

    public void addAmount(Money money) {
        if (money.type == CurrencyType.Rupee) {
            rupeeAmount += money.amount;
        }
        else {
            dollarAmount += money.amount;
        }

    }

    public void takeAmount(Money money) {
        if (money.type == CurrencyType.Rupee) {
            rupeeAmount -= money.amount;
        }
        else {
            dollarAmount -= money.amount;
        }
    }

    public double getTotalRupeeAmount() {
        return (dollarAmount * CurrencyType.Rupee.equivalence) + rupeeAmount;
    }

    public double getTotalDollarAmount() {
        return dollarAmount + (rupeeAmount / CurrencyType.Rupee.equivalence);
    }
}
