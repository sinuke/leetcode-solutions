package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheDuplicateNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findDuplicate(int[] nums, int expected) {
        var solution = new FindTheDuplicateNumber();
        assertEquals(expected, solution.findDuplicate(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,3,4,2,2}, 2),
                Arguments.of(new int[] {3,1,3,4,2}, 3),
                Arguments.of(new int[] {3,3,3,3,3}, 3)
        );
    }

}
