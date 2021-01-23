package com.thoughtworks.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {
    @Test
    void shouldReturnTotalAmountWhenMoneyIsAddedToWallet() {
        Wallet wallet = new Wallet(0);
        Money amount = new Money(100);
        wallet.addAmount(amount);

        assertEquals(100, wallet.totalBalance);
    }

    @Test
    void shouldReturnBalanceAmountWhenMoneyIsTakenFromWallet() {
        Wallet wallet = new Wallet(100);
        Money amount = new Money(52);
        wallet.takeAmount(amount);

        assertEquals(48, wallet.totalBalance);
    }
}
