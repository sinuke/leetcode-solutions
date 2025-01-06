package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MinimumNumbeOfOperationsToMoveAllBallsToEachBoxTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minOperations(String boxes, int[] expected) {
        var minNumberOfOperations = new MinimumNumbeOfOperationsToMoveAllBallsToEachBox();
        assertArrayEquals(expected, minNumberOfOperations.minOperations(boxes));
        assertArrayEquals(expected, minNumberOfOperations.minOperations2(boxes));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("110", new int[] {1,1,3}),
                Arguments.of("001011", new int[] {11,8,5,4,3,4})
        );
    }

}
