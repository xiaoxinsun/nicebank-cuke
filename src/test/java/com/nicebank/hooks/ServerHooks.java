package com.nicebank.hooks;

import com.nicebank.Account;
import com.nicebank.CashSlot;
import com.nicebank.support.TestCashSlot;
import com.nicebank.util.DbUtils;
import com.nicebank.web.AtmServer;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.java.guice.ScenarioScoped;

import javax.inject.Inject;

@ScenarioScoped
public class ServerHooks {

    public static final int PORT = 8887;

    private AtmServer server;
    private CashSlot cashSlot;

    @Inject
    public ServerHooks(TestCashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    @Before
    public void startServer() throws Exception {
        Account account = Account.findFirst("number = ?", DbUtils.DEFAULT_ACCOUNT);
        server = new AtmServer(PORT, cashSlot, account);
        server.start();
    }

    @After
    public void stopServer() throws Exception {
        server.stop();
    }

}
