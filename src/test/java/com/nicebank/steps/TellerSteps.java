package com.nicebank.steps;

import com.nicebank.Account;
import com.nicebank.support.AtmUserInterface;
import com.nicebank.util.DbUtils;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class TellerSteps {

    private AtmUserInterface teller;
    private Account account;

    @Autowired
    public TellerSteps(AtmUserInterface teller) {
        this.teller = teller;
        this.account = Account.findByAccountNumber(DbUtils.DEFAULT_ACCOUNT);
    }

    @When("^I request \\$(\\d+)$")
    public void iRequest$(int amount) throws Throwable {
        teller.withdrawFrom(account, amount);
    }

}
