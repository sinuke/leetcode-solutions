package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveElementTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeElement(int[] input, int value, int[] expected) {
        var removeElement = new RemoveElement();

        var result = removeElement.removeElement(input, value);
        assertEquals(expected.length, result);
        assertArrayEquals(
                expected,
                Arrays.stream(input).limit(result).toArray()
        );
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3, 2, 2, 3}, 3, new int[] {2, 2}),
                Arguments.of(new int[] {0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[] {0, 1, 3, 0, 4})
        );
    }

}
