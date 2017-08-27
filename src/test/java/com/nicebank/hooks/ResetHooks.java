package com.nicebank.hooks;

import com.nicebank.Account;
import com.nicebank.middleware.TransactionQueue;
import com.nicebank.util.DbUtils;
import cucumber.api.java.Before;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class ResetHooks {

    @Before(order = 1)
    public void reset() {
        DbUtils.connectToDB();
        Account.deleteAll();

        TransactionQueue.clear();

        new Account(DbUtils.DEFAULT_ACCOUNT).saveIt();
    }

}
