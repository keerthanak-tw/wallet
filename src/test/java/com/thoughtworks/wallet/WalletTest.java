package com.thoughtworks.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {
    @Test
    void shouldReturnTotalAmountWhenMoneyIsAddedToWallet() {
        Wallet wallet = new Wallet();
        wallet.addAmount(CurrencyType.Rupee, 100);

        assertEquals(100, wallet.getTotalRupeeAmount());
    }

    @Test
    void shouldReturnBalanceAmountWhenMoneyIsTakenFromWallet() throws NoEnoughMoneyException, OutOfMoneyException {
        Wallet wallet = new Wallet();

        wallet.addAmount(CurrencyType.Rupee, 100);
        wallet.takeAmount(CurrencyType.Rupee, 52);

        assertEquals(48, wallet.getTotalRupeeAmount());
    }

    @Test
    void shouldReturnTotalAmountInRupees() {

        Wallet wallet = new Wallet();

        wallet.addAmount(CurrencyType.Rupee, 50);
        wallet.addAmount(CurrencyType.Dollar, 1);

        assertEquals(124.85, wallet.getTotalRupeeAmount(), 0.15);
    }

    @Test
    void shouldReturnTotalAmountInDollars() {
        Wallet wallet = new Wallet();

        wallet.addAmount(CurrencyType.Rupee, 74.85);
        wallet.addAmount(CurrencyType.Dollar, 1);
        wallet.addAmount(CurrencyType.Rupee, 149.7);

        assertEquals(4, wallet.getTotalDollarAmount(), 0.15);
        System.out.println(wallet.moneySet);
    }
}
