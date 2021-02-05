package com.thoughtworks.wallet.currency;

public class CurrencyValue {

    public final CurrencyType type;
    public final double amount;

    public CurrencyValue(CurrencyType type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}
