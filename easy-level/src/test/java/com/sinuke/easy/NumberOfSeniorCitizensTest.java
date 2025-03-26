package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfSeniorCitizensTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countSeniors(String[] details, int expected) {
        var solution = new NumberOfSeniorCitizens();
        assertEquals(expected, solution.countSeniors(details));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"7868190130M7522","5303914400F9211","9273338290F4010"}, 2),
                Arguments.of(new String[] {"1313579440F2036","2921522980M5644"}, 0)
        );
    }

}
