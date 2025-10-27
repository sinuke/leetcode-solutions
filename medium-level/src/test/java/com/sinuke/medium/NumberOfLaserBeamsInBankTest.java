package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfLaserBeamsInBankTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numberOfBeams(String[] bank, int expected) {
        var solution = new NumberOfLaserBeamsInBank();
        assertEquals(expected, solution.numberOfBeams(bank));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"011001","000000","010100","001000"}, 8),
                Arguments.of(new String[] {"000","111","000"}, 0)
        );
    }

}
