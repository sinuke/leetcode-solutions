package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheChildWhoHasTheBallAfterKSecondsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numberOfChild(int n, int k, int expected) {
        var solution = new FindTheChildWhoHasTheBallAfterKSeconds();
        assertEquals(expected, solution.numberOfChild(n, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(3, 5, 1),
                Arguments.of(5, 6, 2),
                Arguments.of(4, 2, 2)
        );
    }

}
