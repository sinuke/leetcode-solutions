package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMaximumAchievableNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void theMaximumAchievableX(int num, int t, int expected) {
        var findMax = new FindMaximumAchievableNumber();
        assertEquals(expected, findMax.theMaximumAchievableX(num, t));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(4, 1, 6),
                Arguments.of(3, 2, 7)
        );
    }

}
