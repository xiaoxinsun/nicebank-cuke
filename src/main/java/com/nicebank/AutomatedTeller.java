package com.nicebank;

public class AutomatedTeller implements Teller {

    private CashSlot cashSlot;

    public AutomatedTeller(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public void withdrawFrom(Account myAccount, int dollars) {
        cashSlot.dispense(dollars);
        myAccount.debit(new Money(dollars, 0));
    }
}
