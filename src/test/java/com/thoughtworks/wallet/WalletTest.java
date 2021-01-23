package com.thoughtworks.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {
    @Test
    void shouldReturnTotalAmountAsMoneyAdded() {
        Wallet wallet = new Wallet(0);
        Money amount = new Money(100);
        wallet.addMoney(amount);

        assertEquals(100, wallet.totalBalance);
    }
}
