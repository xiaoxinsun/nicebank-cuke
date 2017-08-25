package com.nicebank.middleware;

import com.nicebank.Money;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class BalanceStore {

    private static String BALANCE_FILE_PATH = "./balance";

    public static void clear() {
        new File(BALANCE_FILE_PATH).delete();

        setBalance(new Money(0, 0));
    }

    public static Money getBalance() {
        File balanceFile = new File(BALANCE_FILE_PATH);
        try (Scanner scanner = new Scanner(balanceFile)) {
            return new Money(scanner.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setBalance(Money balance) {
        try (PrintWriter writer = new PrintWriter(BALANCE_FILE_PATH, "UTF-8")) {
            writer.println(balance.toString());
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
