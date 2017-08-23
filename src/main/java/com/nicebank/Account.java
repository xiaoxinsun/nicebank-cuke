package com.nicebank;

public class Account {

    private Money balance = new Money();

    public void credit(Money amount) {
        balance = balance.add(amount);
    }

    public void debit(Money amount) {
        balance = balance.minus(amount);
    }

    public Money getBalance() {
        return balance;
    }

}
