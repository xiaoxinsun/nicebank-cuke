package com.nicebank.support;

import com.nicebank.Account;
import com.nicebank.Teller;
import com.nicebank.hooks.ServerHooks;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import javax.inject.Inject;

@ScenarioScoped
public class AtmUserInterface implements Teller {

    private EventFiringWebDriver webDriver;

    @Inject
    public AtmUserInterface(MyWebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void withdrawFrom(Account account, int dollars) {
        webDriver.get("http://localhost:" + ServerHooks.PORT);
        webDriver.findElement(By.id("Amount"))
                .sendKeys(String.valueOf(dollars));
        webDriver.findElement(By.id("Withdraw")).click();
    }
}
