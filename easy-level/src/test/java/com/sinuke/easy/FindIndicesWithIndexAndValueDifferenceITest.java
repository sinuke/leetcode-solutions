package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindIndicesWithIndexAndValueDifferenceITest {

    @ParameterizedTest
    @MethodSource("testData")
    void findIndices(int[] nums, int indexDifference, int valueDifference, int[] expected) {
        assertArrayEquals(expected, new FindIndicesWithIndexAndValueDifferenceI().findIndices(nums, indexDifference, valueDifference));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{5, 1, 4, 1}, 2, 4, new int[]{0, 3}),
                Arguments.of(new int[]{2, 1}, 0, 0, new int[]{0, 0}),
                Arguments.of(new int[]{1, 2, 3}, 2, 4, new int[]{-1, -1})
        );
    }

}
