package com.sinuke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanToIntTest {

    @Test
    void romanToInt() {
        var romanToInt = new RomanToInt();

        assertEquals(3, romanToInt.romanToInt("III"));
        assertEquals(58, romanToInt.romanToInt("LVIII"));
        assertEquals(1994, romanToInt.romanToInt("MCMXCIV"));
    }

}
