package com.nicebank.steps;

import com.nicebank.CashSlot;
import com.nicebank.support.TestCashSlot;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.junit.Assert;

import javax.inject.Inject;

@ScenarioScoped
public class CashSlotSteps {

    private CashSlot cashSlot;

    @Inject
    public CashSlotSteps(TestCashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed -", dollars, cashSlot.contents());
    }

}
