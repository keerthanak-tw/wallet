package com.thoughtworks.wallet;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {
    @Test
    void shouldReturnTotalAmountInRupeesWhenRupeeIsDepositedInWallet() {
        Wallet wallet = new Wallet();
        wallet.deposit(CurrencyType.Rupee, 100);

        assertThat(wallet.getTotalAmount(CurrencyType.Rupee), is(closeTo(100, 0.15)));
    }

    @Test
    void shouldReturnBalanceAmountInRupeeWhenMoneyIsWithdrawnFromWallet() throws OutOfBalanceException, NoDenominationException {
        Wallet wallet = new Wallet();

        wallet.deposit(CurrencyType.Rupee, 100);
        wallet.withdraw(CurrencyType.Rupee, 52);

        assertThat(wallet.getTotalAmount(CurrencyType.Rupee), is(closeTo(48, 0.15)));
    }

    @Test
    void shouldReturnTotalBalanceInRupees() {

        Wallet wallet = new Wallet();

        wallet.deposit(CurrencyType.Rupee, 50);
        wallet.deposit(CurrencyType.Dollar, 1);

        assertThat(wallet.getTotalAmount(CurrencyType.Rupee), is(closeTo(124, 0.85)));
    }

    @Test
    void shouldReturnTotalBalanceInDollars() {
        Wallet wallet = new Wallet();

        wallet.deposit(CurrencyType.Rupee, 74.85);
        wallet.deposit(CurrencyType.Dollar, 1);
        wallet.deposit(CurrencyType.Rupee, 149.7);

        assertThat(wallet.getTotalAmount(CurrencyType.Dollar), is(closeTo(4, 0.15)));
    }
}
