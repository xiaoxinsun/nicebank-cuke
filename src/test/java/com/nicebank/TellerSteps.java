package com.nicebank;

import com.nicebank.support.KnowsTheDomain;
import cucumber.api.java.en.When;

public class TellerSteps {

    private KnowsTheDomain helper;

    public TellerSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @When("^I request \\$(\\d+)$")
    public void iRequest$(int amount) throws Throwable {
        helper.getTeller().withdrawFrom(helper.getMyAccount(), amount);
    }

}
