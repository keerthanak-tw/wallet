package com.thoughtworks.wallet;

import com.thoughtworks.wallet.currency.CurrencyType;
import com.thoughtworks.wallet.currency.CurrencyValue;
import com.thoughtworks.wallet.exceptions.OutOfBalanceException;


public class Wallet {
    public double amount;
    CurrencyValue rupee = new CurrencyValue(CurrencyType.Rupee, 0);
    CurrencyValue dollar = new CurrencyValue(CurrencyType.Dollar, 0);


    public void deposit(CurrencyValue currency) {
        if (currency.type.equals(CurrencyType.Rupee)) {
            amount = rupee.amount + currency.amount;
            rupee = new CurrencyValue(currency.type, amount);
        } else {
            amount = dollar.amount + currency.amount;
            dollar = new CurrencyValue(currency.type, amount);
        }
    }

    public void withdraw(CurrencyValue currency) throws OutOfBalanceException {
        if (currency.type.equals(CurrencyType.Rupee)) {
            if (checkBalance(rupee.amount, currency.amount)) {
                amount = rupee.amount - currency.amount;
                rupee = new CurrencyValue(currency.type, amount);
            } else {
                throw new OutOfBalanceException();
            }
        } else {
            if (checkBalance(dollar.amount, currency.amount)) {
                amount = dollar.amount - currency.amount;
                dollar = new CurrencyValue(currency.type, amount);
            }
            else {
                throw new OutOfBalanceException();
            }
        }
    }

    private boolean checkBalance(double balance, double amountToWithdraw) {
        return (balance - amountToWithdraw) > 0;
    }

    public double getTotalAmount(CurrencyType type) {
        double totalAmount = 0;
        totalAmount += rupee.amount + dollar.amount * CurrencyType.getRupeeValue();
        return type.equals(CurrencyType.Rupee) ? totalAmount : totalAmount / CurrencyType.getRupeeValue();
    }
}
