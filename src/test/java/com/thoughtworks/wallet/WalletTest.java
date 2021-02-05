package com.thoughtworks.wallet;

import com.thoughtworks.wallet.currency.CurrencyType;
import com.thoughtworks.wallet.currency.CurrencyValue;
import com.thoughtworks.wallet.exceptions.OutOfBalanceException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WalletTest {

    @Test
    void shouldReturnTotalAmountInRupeeWhenRupeeIsDepositedInWallet() {
        Wallet wallet = new Wallet();
        CurrencyValue currency = new CurrencyValue(CurrencyType.Rupee, 100);

        wallet.deposit(currency);

        assertThat(wallet.getTotalAmount(CurrencyType.Rupee), is(closeTo(100, 0.15)));
    }

    @Test
    void shouldReturnTotalAmountInDollarWhenRupeeIsDepositedInWallet() {
        Wallet wallet = new Wallet();
        CurrencyValue currency = new CurrencyValue(CurrencyType.Rupee, 100);

        wallet.deposit(currency);

        assertThat(wallet.getTotalAmount(CurrencyType.Dollar), is(closeTo(1.35, 0.15)));
    }

    @Test
    void shouldReturnBalanceAmountInRupeeWhenMoneyIsWithdrawnFromWallet() throws OutOfBalanceException {
        Wallet wallet = new Wallet();
        CurrencyValue currency1 = new CurrencyValue(CurrencyType.Rupee, 100);
        CurrencyValue currency2 = new CurrencyValue(CurrencyType.Rupee, 52);

        wallet.deposit(currency1);
        wallet.withdraw(currency2);

        assertThat(wallet.getTotalAmount(CurrencyType.Rupee), is(closeTo(48, 0.15)));
    }

    @Test
    void shouldReturnTotalBalanceInRupees() {
        Wallet wallet = new Wallet();
        CurrencyValue currency1 = new CurrencyValue(CurrencyType.Rupee, 50);
        CurrencyValue currency2 = new CurrencyValue(CurrencyType.Dollar, 1);

        wallet.deposit(currency1);
        wallet.deposit(currency2);

        assertThat(wallet.getTotalAmount(CurrencyType.Rupee), is(closeTo(124, 0.85)));
    }

    @Test
    void shouldReturnTotalBalanceInDollars() {
        Wallet wallet = new Wallet();
        CurrencyValue currency1 = new CurrencyValue(CurrencyType.Rupee, 74.85);
        CurrencyValue currency2 = new CurrencyValue(CurrencyType.Dollar, 1);
        CurrencyValue currency3 = new CurrencyValue(CurrencyType.Rupee, 149.7);

        wallet.deposit(currency1);
        wallet.deposit(currency2);
        wallet.deposit(currency3);

        assertThat(wallet.getTotalAmount(CurrencyType.Dollar), is(closeTo(4, 0.15)));
    }
}
