package com.nicebank.support;

import com.nicebank.Account;
import com.nicebank.CashSlot;
import com.nicebank.Teller;
import com.nicebank.util.DbUtils;
import org.javalite.activejdbc.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class KnowsTheDomain {
    private Account myAccount;
    private CashSlot cashSlot;
    private Teller teller;
    private EventFiringWebDriver webDriver;

    public KnowsTheDomain() {
        DbUtils.connectToDB();
        Account.deleteAll();
    }

    public Account getMyAccount() {
        if (myAccount == null) {
            myAccount = new Account(DbUtils.DEFAULT_ACCOUNT);
            myAccount.saveIt();
        }
        return myAccount;
    }

    public CashSlot getCashSlot() {
        if (cashSlot == null) {
            cashSlot = new CashSlot();
        }
        return this.cashSlot;
    }

    public Teller getTeller() {
        if (teller == null) {
            teller = new AtmUserInterface(this);
        }
        return this.teller;
    }

    public EventFiringWebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = new EventFiringWebDriver(new FirefoxDriver());
        }
        return webDriver;
    }
}
