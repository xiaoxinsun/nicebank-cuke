package com.nicebank;

import com.nicebank.middleware.BalanceStore;
import com.nicebank.middleware.TransactionQueue;
import org.javalite.activejdbc.Model;

public class Account extends Model {

    private TransactionQueue queue = new TransactionQueue();

    public void credit(Money amount) {
        queue.write("+" + amount.toString());
    }

    public void debit(Money amount) {
        queue.write("-" + amount.toString());
    }

    public int getNumber() {
        return getInteger("number");
    }

    public Money getBalance() {
        return new Money(getString("balance"));
    }

    public void setBalance(Money amount) {
        setString("balance", amount.toString());
        saveIt();
    }

}
