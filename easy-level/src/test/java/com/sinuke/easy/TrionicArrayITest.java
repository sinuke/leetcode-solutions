package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrionicArrayITest {

    @ParameterizedTest
    @MethodSource("testData")
    void isTrionic(int[] nums, boolean expected) {
        var solution = new TrionicArrayI();
        assertEquals(expected, solution.isTrionic(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,3,5,4,2,6}, true),
                Arguments.of(new int[] {2,1,3}, false)
        );
    }

}
