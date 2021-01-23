package com.thoughtworks.wallet;

public class Money {
    public final double amount;
    public final CurrencyType type;

    public Money(double money, CurrencyType type) {
        this.amount = money;
        this.type = type;
    }

    public double convertToRupee(){
        return amount * type.equivalence;
    }

    public double convertToDollar(){
        return amount / type.equivalence;
    }
}
