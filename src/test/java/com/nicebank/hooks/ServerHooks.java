package com.nicebank.hooks;

import com.nicebank.support.KnowsTheAccount;
import com.nicebank.support.KnowsTheCashSlot;
import com.nicebank.web.AtmServer;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServerHooks {

    public static final int PORT = 8887;

    private AtmServer server;
    private KnowsTheAccount accountHelper;
    private KnowsTheCashSlot knowsTheCashSlot;

    public ServerHooks(KnowsTheAccount accountHelper, KnowsTheCashSlot knowsTheCashSlot) {
        this.accountHelper = accountHelper;
        this.knowsTheCashSlot = knowsTheCashSlot;
    }

    @Before
    public void startServer() throws Exception {
        server = new AtmServer(PORT, knowsTheCashSlot.getCashSlot(), accountHelper.getMyAccount());
        server.start();
    }

    @After
    public void stopServer() throws Exception {
        server.stop();
    }

}
