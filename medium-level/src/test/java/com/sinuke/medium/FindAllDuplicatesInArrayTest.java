package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindAllDuplicatesInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findDuplicates(int[] nums, List<Integer> expected) {
        var solution = new FindAllDuplicatesInArray();
        assertEquals(expected, solution.findDuplicates(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {4,3,2,7,8,2,3,1}, List.of(2, 3)),
                Arguments.of(new int[] {1,1,2}, List.of(1)),
                Arguments.of(new int[] {1}, List.of())
        );
    }

}
