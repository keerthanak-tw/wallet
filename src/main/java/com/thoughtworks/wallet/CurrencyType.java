package com.thoughtworks.wallet;

public enum CurrencyType {
    Rupee(74.85),
    Dollar(1);

    public double equivalence;

    CurrencyType(double value) {
        this.equivalence = value;
    }

    public static double getRupeeValue() {
        return Rupee.equivalence;
    }
}
