package com.nicebank.steps;

import com.nicebank.CashSlot;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class CashSlotSteps {

    private CashSlot cashSlot;

    @Autowired
    public CashSlotSteps(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed -", dollars, cashSlot.contents());
    }

}
