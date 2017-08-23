package com.nicebank;

import com.nicebank.support.KnowsTheDomain;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import static org.junit.Assert.assertEquals;

public class AccountSteps {

    private final KnowsTheDomain helper;

    public AccountSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        helper.getMyAccount().credit(amount);

        assertEquals("Incorrect account balance -", amount, helper.getMyAccount().getBalance());
    }

    @And("^the balance of my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceOfMyAccountShouldBe$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        assertEquals("Incorrect account balance -", amount, helper.getMyAccount().getBalance());
    }
}
