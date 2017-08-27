package com.nicebank;

import com.nicebank.support.KnowsTheCashSlot;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class CashSlotSteps {

    private KnowsTheCashSlot helper;

    public CashSlotSteps(KnowsTheCashSlot helper) {
        this.helper = helper;
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed -", dollars, helper.getCashSlot().contents());
    }

}
