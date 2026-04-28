package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidElementsInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findValidElements(int[] nums, List<Integer> expected) {
        assertEquals(expected, new ValidElementsInArray().findValidElements(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 4, 2, 3, 2}, List.of(1, 2, 4, 3, 2)),
                Arguments.of(new int[]{5, 5, 5, 5}, List.of(5, 5)),
                Arguments.of(new int[]{1}, List.of(1)),
                Arguments.of(new int[]{93,31,2,13}, List.of(93,31,13))
        );
    }

}
