package com.thoughtworks.wallet;

import com.thoughtworks.wallet.enums.CurrencyType;
import com.thoughtworks.wallet.exceptions.NoDenominationException;
import com.thoughtworks.wallet.exceptions.OutOfBalanceException;

import java.util.HashMap;
import java.util.Map.Entry;

public class Wallet {
    public double amount;
    HashMap<CurrencyType, Double> moneySet = new HashMap<>();


    public void deposit(CurrencyType type, double amount) {
        if ( moneySet.get(type) == null) {
            moneySet.put(type, amount);
        }
        else {
            this.amount = moneySet.get(type) + amount;
            moneySet.put(type, this.amount);
        }
    }

    public void withdraw(CurrencyType type, double amount) throws NoDenominationException, OutOfBalanceException {
        if ( moneySet.get(type) == null) {
            throw new NoDenominationException();
        }
        else {
            this.amount = moneySet.get(type);
            if ( this.amount < amount){
                throw new OutOfBalanceException();
            }
            this.amount -= amount;
            moneySet.put(type, this.amount);
        }
    }

    public double getTotalAmount(CurrencyType type) {
        double totalAmount = 0;

        for (Object o : moneySet.entrySet()) {
            var mapElement = (Entry) o;
            CurrencyType key = (CurrencyType) mapElement.getKey();
            if (key == CurrencyType.Rupee) {
                totalAmount += (double) mapElement.getValue();
            } else {
                totalAmount += (double) mapElement.getValue() * CurrencyType.getRupeeValue();
            }
        }
        return type.equals(CurrencyType.Rupee)?totalAmount:totalAmount/CurrencyType.getRupeeValue();
    }

}
