package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindAllKDistantIndicesInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findKDistantIndices(int[] nums, int key, int k, List<Integer> expected) {
        var solution =  new FindAllKDistantIndicesInArray();
        assertEquals(expected, solution.findKDistantIndices(nums, key, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,4,9,1,3,9,5}, 9, 1, List.of(1,2,3,4,5,6)),
                Arguments.of(new int[] {2,2,2,2,2}, 2, 2, List.of(0,1,2,3,4))
        );
    }

}
