package com.nicebank;

import com.nicebank.middleware.TransactionQueue;
import com.nicebank.util.DbUtils;
import org.javalite.activejdbc.Model;

public class Account extends Model {

    private TransactionQueue queue = new TransactionQueue();

    public Account() {
    }

    public Account(int number) {
        setInteger("number", number);
        setString("balance", "0.00");
    }

    public void credit(Money amount) {
        queue.write(String.format("%s%s,%s", "+", amount.toString(), DbUtils.DEFAULT_ACCOUNT));
    }

    public void debit(Money amount) {
        queue.write(String.format("%s%s,%s", "-", amount.toString(), DbUtils.DEFAULT_ACCOUNT));
    }

    public int getNumber() {
        return getInteger("number");
    }

    public Money getBalance() {
        refresh();
        return new Money(getString("balance"));
    }

    public void setBalance(Money amount) {
        setString("balance", amount.toString());
        saveIt();
    }

    public static Account findByAccountNumber(int accountNumber) {
        return findFirst("number = ?", accountNumber);
    }

}
