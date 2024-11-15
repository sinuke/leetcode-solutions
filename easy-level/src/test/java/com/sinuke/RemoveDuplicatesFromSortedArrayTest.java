package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesFromSortedArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeDuplicates(int[] input, int[] expected) {
        var removeDuplicates = new RemoveDuplicatesFromSortedArray();

        var result = removeDuplicates.removeDuplicates(input);
        assertEquals(expected.length, result);
        assertArrayEquals(
                expected,
                Arrays.stream(input).limit(result).toArray()
        );
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 1, 2}, new int[] {1, 2}),
                Arguments.of(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[] {0, 1, 2, 3, 4})
        );
    }

}
