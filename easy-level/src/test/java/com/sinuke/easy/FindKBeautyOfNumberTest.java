package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindKBeautyOfNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void divisorSubstrings(int num, int k, int expected) {
        var solution = new FindKBeautyOfNumber();
        assertEquals(expected, solution.divisorSubstrings(num, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(240, 2, 2),
                Arguments.of(430043, 2, 2)
        );
    }

}
