package com.nicebank.steps;

import com.nicebank.Account;
import com.nicebank.Money;
import com.nicebank.util.DbUtils;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import static org.junit.Assert.assertEquals;

public class AccountSteps {

    private Account testAccount;

    public AccountSteps() {
        testAccount = Account.findByAccountNumber(DbUtils.DEFAULT_ACCOUNT);
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        testAccount.credit(amount);
    }

    @And("^the balance of my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceOfMyAccountShouldBe$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        int timeoutMs = 3000;
        int pollIntervalMs = 100;

        while (!testAccount.getBalance().equals(amount) && timeoutMs > 0) {
            Thread.sleep(pollIntervalMs);
            timeoutMs -= pollIntervalMs;
        }
        assertEquals("Incorrect account balance -", amount, testAccount.getBalance());
    }
}
