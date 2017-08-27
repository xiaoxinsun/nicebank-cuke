package com.nicebank;

import com.nicebank.support.KnowsTheAccount;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import static org.junit.Assert.assertEquals;

public class AccountSteps {

    private final KnowsTheAccount helper;

    public AccountSteps(KnowsTheAccount helper) {
        this.helper = helper;
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        helper.getMyAccount().credit(amount);
    }

    @And("^the balance of my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceOfMyAccountShouldBe$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        int timeoutMs = 3000;
        int pollIntervalMs = 100;

        while (!helper.getMyAccount().getBalance().equals(amount) && timeoutMs > 0) {
            Thread.sleep(pollIntervalMs);
            timeoutMs -= pollIntervalMs;
        }
        assertEquals("Incorrect account balance -", amount, helper.getMyAccount().getBalance());
    }
}
