package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReformatPhoneNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reformatNumber(String number, String expected) {
        var solution = new ReformatPhoneNumber();
        assertEquals(expected, solution.reformatNumber(number));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1-23-45 6", "123-456"),
                Arguments.of("123 4-567", "123-45-67"),
                Arguments.of("123 4-5678", "123-456-78"),
                Arguments.of("123 4-5678--9", "123-456-789"),
                Arguments.of("123 4", "12-34"),
                Arguments.of("1-2", "12")
        );
    }

}
