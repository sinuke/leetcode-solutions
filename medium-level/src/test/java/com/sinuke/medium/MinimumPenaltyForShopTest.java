package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumPenaltyForShopTest {

    @ParameterizedTest
    @MethodSource("testData")
    void bestClosingTime(String customers, int expected) {
        var solution = new MinimumPenaltyForShop();
        assertEquals(expected, solution.bestClosingTime(customers));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("YYNY", 2),
                Arguments.of("NNNNN", 0),
                Arguments.of("YYYY", 4),
                Arguments.of("YNY", 1),
                Arguments.of("YYYYY", 5),
                Arguments.of("NNNYNN", 0),
                Arguments.of("NYYNYYY", 7),
                Arguments.of("NYNNNYYN", 0)
        );
    }

}
