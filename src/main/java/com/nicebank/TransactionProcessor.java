package com.nicebank;

import com.nicebank.middleware.BalanceStore;
import com.nicebank.middleware.TransactionQueue;

public class TransactionProcessor {

    private TransactionQueue queue = new TransactionQueue();

    public void process() {
        do {
            String message = queue.read();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

            if (message.length() > 0) {
                Money balance = BalanceStore.getBalance();
                Money transactionAmount = new Money(message.substring(1));

                if (isCreditTransaction(message)) {
                    BalanceStore.setBalance(balance.add(transactionAmount));
                } else {
                    BalanceStore.setBalance(balance.minus(transactionAmount));
                }
            }
        } while (true);
    }

    private boolean isCreditTransaction(String message) {
        return !message.startsWith("-");
    }

}
