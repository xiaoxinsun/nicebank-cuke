package com.nicebank;

import com.nicebank.middleware.BalanceStore;
import com.nicebank.middleware.TransactionQueue;

public class Account {

    private TransactionQueue queue = new TransactionQueue();

    public void credit(Money amount) {
        queue.write("+" + amount.toString());
    }

    public void debit(Money amount) {
        queue.write("-" + amount.toString());
    }

    public Money getBalance() {
        return BalanceStore.getBalance();
    }

}
