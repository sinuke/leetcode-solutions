package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SelfDividingNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void selfDividingNumbers(int left, int right, List<Integer> expected) {
        var solution = new SelfDividingNumbers();
        assertEquals(expected, solution.selfDividingNumbers(left, right));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, 22, List.of(1,2,3,4,5,6,7,8,9,11,12,15,22)),
                Arguments.of(47, 85, List.of(48,55,66,77))
        );
    }

}