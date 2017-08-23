package com.nicebank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Money {

    private final int dollars;
    private final int cents;

//    public Money(String amount) {
//        Pattern pattern = Pattern.compile("^([\\d]+)\\.([\\d][\\d])$");
//        Matcher matcher = pattern.matcher(amount);
//
//        matcher.find();
//        this.dollars = Integer.parseInt(matcher.group(1));
//        this.cents = Integer.parseInt(matcher.group(2));
//    }

    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public Money() {
        this(0, 0);
    }

    public Money add(Money amount) {
        return new Money(this.dollars + amount.dollars, this.cents + amount.cents);
    }

    public Money minus(Money amount) {
        return new Money(this.dollars - amount.dollars, this.cents - amount.cents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (dollars != money.dollars) return false;
        return cents == money.cents;
    }

    @Override
    public int hashCode() {
        int result = dollars;
        result = 31 * result + cents;
        return result;
    }

    @Override
    public String toString() {
        return "Money{" +
                "dollars=" + dollars +
                ", cents=" + cents +
                '}';
    }

}
