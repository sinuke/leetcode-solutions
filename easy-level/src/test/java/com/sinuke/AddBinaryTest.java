package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AddBinaryTest {

    @ParameterizedTest
    @MethodSource("testData")
    void addBinary(String a, String b, String expected) {
        var addBinary = new AddBinary();

        assertEquals(expected, addBinary.addBinary(a, b));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("11", "1", "100"),
                Arguments.of("1010", "1011", "10101"),
                Arguments.of("1111", "1111", "11110"),
                Arguments.of("0", "0", "0")
        );
    }

}
