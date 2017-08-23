package com.nicebank.support;

import com.nicebank.Account;
import com.nicebank.AutomatedTeller;
import com.nicebank.CashSlot;
import com.nicebank.Teller;
import com.nicebank.web.AtmUserInterface;

public class KnowsTheDomain {
    private Account myAccount;
    private CashSlot cashSlot;
    private Teller teller;

    public Account getMyAccount() {
        if (myAccount == null) {
            myAccount = new Account();
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
            teller = new AtmUserInterface();
        }
        return this.teller;
    }
}
