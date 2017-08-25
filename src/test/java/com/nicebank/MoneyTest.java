package com.nicebank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyTest {

    @Test
    public void toStringShouldReturnTwoDigitsCents() {
        assertEquals("1.02", new Money(1, 2).toString());
        assertEquals("1.20", new Money(1, 20).toString());
    }

}