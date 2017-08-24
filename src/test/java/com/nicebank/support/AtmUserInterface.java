package com.nicebank.support;

import com.nicebank.Account;
import com.nicebank.Teller;
import com.nicebank.hooks.ServerHooks;
import org.openqa.selenium.By;

public class AtmUserInterface implements Teller {

    private KnowsTheDomain helper;

    public AtmUserInterface(KnowsTheDomain helper) {
        this.helper = helper;
    }

    public void withdrawFrom(Account account, int dollars) {
        helper.getWebDriver().get("http://localhost:" + ServerHooks.PORT);
        helper.getWebDriver().findElement(By.id("Amount"))
                .sendKeys(String.valueOf(dollars));
        helper.getWebDriver().findElement(By.id("Withdraw")).click();
    }
}
