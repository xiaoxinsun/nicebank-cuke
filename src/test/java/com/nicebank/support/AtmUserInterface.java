package com.nicebank.support;

import com.nicebank.Account;
import com.nicebank.Teller;
import com.nicebank.hooks.ServerHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class AtmUserInterface implements Teller {

    private EventFiringWebDriver webDriver;

    @Autowired
    public AtmUserInterface(EventFiringWebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void withdrawFrom(Account account, int dollars) {
        webDriver.get("http://localhost:" + ServerHooks.PORT);
        webDriver.findElement(By.id("Amount"))
                .sendKeys(String.valueOf(dollars));
        webDriver.findElement(By.id("Withdraw")).click();
    }
}
