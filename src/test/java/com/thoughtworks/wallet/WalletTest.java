package com.thoughtworks.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {
    @Test
    void shouldReturnTotalAmountWhenMoneyIsAddedToWallet() {
        Wallet wallet = new Wallet();
        Money amount = new Money(100, CurrencyType.Rupee);
        wallet.addAmount(amount);

        assertEquals(100, wallet.rupeeAmount);
    }

    @Test
    void shouldReturnBalanceAmountWhenMoneyIsTakenFromWallet() {
        Wallet wallet = new Wallet();
        Money addMoney = new Money(100, CurrencyType.Rupee);
        Money takeMoney = new Money(52, CurrencyType.Rupee);


        wallet.addAmount(addMoney);
        wallet.takeAmount(takeMoney);

        assertEquals(48, wallet.rupeeAmount);
    }

    @Test
    void shouldReturnTotalAmountInRupees() {

        Wallet wallet = new Wallet();
        Money rupee = new Money(50, CurrencyType.Rupee);
        Money dollar = new Money(1, CurrencyType.Dollar);


        wallet.addAmount(rupee);
        wallet.addAmount(dollar);

        assertEquals(124.85, wallet.getTotalRupeeAmount(), 0.15);
    }

    @Test
    void shouldReturnTotalAmountInDollars() {
        Wallet wallet = new Wallet();
        Money rupeeOne = new Money(74.85, CurrencyType.Rupee);
        Money dollar = new Money(1, CurrencyType.Dollar);
        Money rupeeTwo = new Money(149.7, CurrencyType.Rupee);


        wallet.addAmount(rupeeOne);
        wallet.addAmount(dollar);
        wallet.addAmount(rupeeTwo);

        assertEquals(4, wallet.getTotalDollarAmount(), 0.15);
    }
}
