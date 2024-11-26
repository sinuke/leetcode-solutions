package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MajorityElementTest {

    @ParameterizedTest
    @MethodSource("testData")
    void majorityElement(int[] input, int expected) {
        var majorityElement = new MajorityElement();

        assertEquals(expected, majorityElement.majorityElement(input));
        assertEquals(expected, majorityElement.majorityElementSort(input));
        assertEquals(expected, majorityElement.majorityElementVote(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1}, 1),
                Arguments.of(new int[] {3, 3, 4}, 3),
                Arguments.of(new int[] {3, 2, 3}, 3),
                Arguments.of(new int[] {2, 2, 1, 1, 1, 2, 2}, 2)
        );
    }

}
