package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindScoreOfArrayAfterMarkingAllElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findScore(int[] nums, long expected) {
        var findScore = new FindScoreOfArrayAfterMarkingAllElements();
        assertEquals(expected, findScore.findScore(nums));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void findScoreFromLeetCode(int[] nums, long expected) {
        var findScore = new FindScoreOfArrayAfterMarkingAllElements();
        assertEquals(expected, findScore.findScoreFromLeetCode(nums));
    }
    
    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2, 1, 3, 4, 5, 2}, 7),
                Arguments.of(new int[] {2, 3, 5, 1, 3, 2}, 5),
                Arguments.of(new int[] {10, 44, 10, 8, 48, 30, 17, 38, 41, 27, 16, 33, 45, 45, 34, 30, 22, 3, 42, 42}, 212)
        );
    }
    
}
