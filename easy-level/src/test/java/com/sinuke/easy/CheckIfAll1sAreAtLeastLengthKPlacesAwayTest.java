package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfAll1sAreAtLeastLengthKPlacesAwayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void kLengthApart(int[] nums, int k, boolean expected) {
        var solution = new CheckIfAll1sAreAtLeastLengthKPlacesAway();
        assertEquals(expected, solution.kLengthApart(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,0,0,0,1,0,0,1}, 2, true),
                Arguments.of(new int[] {1,0,0,1,0,1}, 2, false)
        );
    }

}
