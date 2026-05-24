package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesFromSortedArrayIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeDuplicates(int[] nums, int[] expectedNums) {
        int k = new RemoveDuplicatesFromSortedArrayII().removeDuplicates(nums);
        assertEquals(expectedNums.length, k);
        assertArrayEquals(expectedNums, Arrays.copyOf(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, new int[]{1, 1, 2, 2, 3}),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 3, 3})
        );
    }

}
