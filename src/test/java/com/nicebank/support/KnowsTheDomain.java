package com.nicebank.support;

import com.nicebank.Account;
import com.nicebank.CashSlot;

public class KnowsTheDomain {
    private Account myAccount;
    private CashSlot cashSlot;

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
}
