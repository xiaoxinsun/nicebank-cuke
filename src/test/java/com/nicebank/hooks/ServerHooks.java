package com.nicebank.hooks;

import com.nicebank.support.KnowsTheDomain;
import com.nicebank.web.AtmServer;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServerHooks {

    public static final int PORT = 8887;

    private AtmServer server;
    private KnowsTheDomain helper;

    public ServerHooks(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Before
    public void startServer() throws Exception {
        server = new AtmServer(PORT, helper.getCashSlot(), helper.getMyAccount());
        server.start();
    }

    @After
    public void stopServer() throws Exception {
        server.stop();
    }

}
