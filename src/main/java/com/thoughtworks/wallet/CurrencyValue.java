package com.thoughtworks.wallet;

import com.thoughtworks.wallet.enums.CurrencyType;

public class CurrencyValue {

    public final CurrencyType type;
    public final double amount;

    public CurrencyValue(CurrencyType type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}
