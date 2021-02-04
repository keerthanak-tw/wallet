package com.thoughtworks.wallet;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {
    @Test
    void shouldReturnTotalAmountWhenMoneyIsAddedToWallet() {
        Wallet wallet = new Wallet();
        wallet.deposit(CurrencyType.Rupee, 100);

        assertThat(wallet.getTotalAmount(CurrencyType.Rupee), is(closeTo(100, 0.15)));
    }

    @Test
    void shouldReturnBalanceAmountWhenMoneyIsTakenFromWallet() throws OutOfBalanceException, NoDenominationException {
        Wallet wallet = new Wallet();

        wallet.deposit(CurrencyType.Rupee, 100);
        wallet.withdraw(CurrencyType.Rupee, 52);

        assertThat(wallet.getTotalAmount(CurrencyType.Rupee), is(closeTo(48, 0.15)));
    }

    @Test
    void shouldReturnTotalAmountInRupees() {

        Wallet wallet = new Wallet();

        wallet.deposit(CurrencyType.Rupee, 50);
        wallet.deposit(CurrencyType.Dollar, 1);

        assertThat(wallet.getTotalAmount(CurrencyType.Rupee), is(closeTo(124, 0.85)));
    }

    @Test
    void shouldReturnTotalAmountInDollars() {
        Wallet wallet = new Wallet();

        wallet.deposit(CurrencyType.Rupee, 74.85);
        wallet.deposit(CurrencyType.Dollar, 1);
        wallet.deposit(CurrencyType.Rupee, 149.7);

        assertThat(wallet.getTotalAmount(CurrencyType.Dollar), is(closeTo(4, 0.15)));
    }
}
