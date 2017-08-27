package com.nicebank.support;

import com.nicebank.CashSlot;

public class KnowsTheCashSlot {

    private CashSlot cashSlot;

    public CashSlot getCashSlot() {
        if (cashSlot == null) {
            cashSlot = new CashSlot();
        }
        return this.cashSlot;
    }


}
