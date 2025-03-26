package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindIfDigitGameCanBeWonTest {

    @ParameterizedTest
    @MethodSource("testData")
    void canAliceWin(int[] nums, boolean expected) {
        var solution = new FindIfDigitGameCanBeWon();
        assertEquals(expected, solution.canAliceWin(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4,10}, false),
                Arguments.of(new int[] {1,2,3,4,5,14}, true),
                Arguments.of(new int[] {5,5,5,25}, true)
        );
    }

}
