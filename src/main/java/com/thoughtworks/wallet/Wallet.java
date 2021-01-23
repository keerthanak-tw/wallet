package com.thoughtworks.wallet;

import java.util.HashMap;
import java.util.Map.Entry;

public class Wallet {
    public double amount;
    HashMap<CurrencyType, Double> moneySet = new HashMap<>();


    public void addAmount(CurrencyType type, double amount) {
        if ( moneySet.get(type) == null) {
            moneySet.put(type, amount);
        }
        else {
            this.amount = moneySet.get(type) + amount;
            moneySet.put(type, this.amount);
        }
    }

    public void takeAmount(CurrencyType type, double amount) throws OutOfMoneyException, NoEnoughMoneyException {
        if ( moneySet.get(type) == null) {
            throw new OutOfMoneyException();
        }
        else {
            this.amount = moneySet.get(type);
            if ( this.amount < amount){
                throw new NoEnoughMoneyException();
            }
            this.amount -= amount;
            moneySet.put(type, this.amount);
        }
    }

    public double getTotalRupeeAmount() {
        double totalRupeeAmount = 0;

        for (Object o : moneySet.entrySet()) {
            var mapElement = (Entry) o;
            CurrencyType key = (CurrencyType) mapElement.getKey();
            if (key == CurrencyType.Rupee) {
                totalRupeeAmount += (double) mapElement.getValue();
            } else {
                totalRupeeAmount += (double) mapElement.getValue() * CurrencyType.getRupeeValue();
            }
        }
        return totalRupeeAmount;
    }

    public double getTotalDollarAmount() {
        return getTotalRupeeAmount() / CurrencyType.getRupeeValue();
    }
}
