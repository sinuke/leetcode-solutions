package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheHighestAltitudeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void largestAltitude(int[] gain, int expected) {
        var solution = new FindTheHighestAltitude();
        assertEquals(expected, solution.largestAltitude(gain));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {-5,1,5,0,-7}, 1),
                Arguments.of(new int[] {-4,-3,-2,-1,4,3,2}, 0)
        );
    }

}
