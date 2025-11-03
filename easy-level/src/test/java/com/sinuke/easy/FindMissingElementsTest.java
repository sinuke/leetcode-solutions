package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMissingElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findMissingElements(int[] nums, List<Integer> expected) {
        var solution = new FindMissingElements();
        assertEquals(expected, solution.findMissingElements(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,4,2,5}, List.of(3)),
                Arguments.of(new int[] {7,8,6,9}, List.of()),
                Arguments.of(new int[] {5,1}, List.of(2,3,4))
        );
    }

}
