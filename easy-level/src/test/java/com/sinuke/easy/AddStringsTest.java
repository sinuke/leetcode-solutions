package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddStringsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void addStrings(String num1, String num2, String expected) {
        var addStrings = new AddStrings();
        assertEquals(expected, addStrings.addStrings(num1, num2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("11", "123", "134"),
                Arguments.of("456", "77", "533"),
                Arguments.of("111", "111", "222"),
                Arguments.of("9999", "9999", "19998"),
                Arguments.of("0", "0", "0"),
                Arguments.of("1", "0", "1"),
                Arguments.of("1", "9", "10")
        );
    }

}