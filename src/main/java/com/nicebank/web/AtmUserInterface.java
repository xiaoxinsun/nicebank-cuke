package com.nicebank.web;

import com.nicebank.Account;
import com.nicebank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class AtmUserInterface implements Teller {

    private final EventFiringWebDriver webDriver;

    public AtmUserInterface() {
        webDriver = new EventFiringWebDriver(new FirefoxDriver());
    }

    public void withdrawFrom(Account account, int dollars) {
        try {
            //TODO: use Chrome Driver or run from Linux
            webDriver.get("http://localhost:9988");
            webDriver.findElement(By.id("Amount"))
                    .sendKeys(String.valueOf(dollars));
            webDriver.findElement(By.id("Withdraw")).click();
        } finally {
            webDriver.close();
        }
    }
}
