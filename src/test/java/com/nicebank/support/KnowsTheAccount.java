package com.nicebank.support;

import com.nicebank.Account;
import com.nicebank.util.DbUtils;

public class KnowsTheAccount {

    private Account myAccount;

    public KnowsTheAccount() {
        DbUtils.connectToDB();
        Account.deleteAll();
    }

    public Account getMyAccount() {
        if (myAccount == null) {
            myAccount = new Account(DbUtils.DEFAULT_ACCOUNT);
            myAccount.saveIt();
        }
        return myAccount;
    }

}
