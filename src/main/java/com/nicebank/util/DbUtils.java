package com.nicebank.util;

import org.javalite.activejdbc.Base;

public class DbUtils {

    public static final int DEFAULT_ACCOUNT = 1234;

    public static void connectToDB() {
        if (!Base.hasConnection()) {
            Base.open(
                    "org.h2.Driver",
                    "jdbc:h2:tcp://localhost/~/bank?defaultSchema=bank",
                    "teller", "password"
            );
        }
    }

}
