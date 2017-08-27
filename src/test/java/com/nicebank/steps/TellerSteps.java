package com.nicebank.steps;

import com.nicebank.Account;
import com.nicebank.support.AtmUserInterface;
import com.nicebank.util.DbUtils;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

import javax.inject.Inject;

@ScenarioScoped
public class TellerSteps {

    private AtmUserInterface teller;
    private Account account;

    @Inject
    public TellerSteps(AtmUserInterface teller) {
        this.teller = teller;
        this.account = Account.findByAccountNumber(DbUtils.DEFAULT_ACCOUNT);
    }

    @When("^I request \\$(\\d+)$")
    public void iRequest$(int amount) throws Throwable {
        teller.withdrawFrom(account, amount);
    }

}
