package com.nicebank.hooks;

import com.nicebank.middleware.BalanceStore;
import com.nicebank.middleware.TransactionQueue;
import cucumber.api.java.Before;

public class ResetHooks {

    @Before
    public void reset() {
        TransactionQueue.clear();
        BalanceStore.clear();
    }

}
