package com.nicebank.support;

import com.nicebank.Teller;

public class KnowsTheTeller {

    private Teller teller;
    private MyWebDriver webDriver;

    public KnowsTheTeller(MyWebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Teller getTeller() {
        if (teller == null) {
            teller = new AtmUserInterface(webDriver);
        }
        return this.teller;
    }

}
