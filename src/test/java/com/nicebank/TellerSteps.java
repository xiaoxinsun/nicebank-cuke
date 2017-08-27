package com.nicebank;

import com.nicebank.support.KnowsTheAccount;
import com.nicebank.support.KnowsTheTeller;
import cucumber.api.java.en.When;

public class TellerSteps {

    private KnowsTheTeller helper;
    private KnowsTheAccount accountHelper;

    public TellerSteps(KnowsTheTeller helper, KnowsTheAccount accountHelper) {
        this.helper = helper;
        this.accountHelper = accountHelper;
    }

    @When("^I request \\$(\\d+)$")
    public void iRequest$(int amount) throws Throwable {
        helper.getTeller().withdrawFrom(accountHelper.getMyAccount(), amount);
    }

}
